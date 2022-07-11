package com.sareto.sarorientstore.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.sareto.sarorientstore.data.repositories.UserRepository
import com.sareto.sarorientstore.data.utility.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AuthViewModel: ViewModel() {
    private val _userRegistrationStatus = MutableLiveData<Resource<AuthResult>>()
    val userRegistrationStatus: LiveData<Resource<AuthResult>> = _userRegistrationStatus
    private val _userSignInStatus = MutableLiveData<Resource<AuthResult>>()
    val userSignInStatus: LiveData<Resource<AuthResult>> = _userSignInStatus
    private val userRepo = UserRepository()
    fun registerUser(name:String, email:String, password:String){
        _userRegistrationStatus.postValue(Resource.Loading())
        viewModelScope.launch (Dispatchers.Main) {
           try {
               val regResult = userRepo.createUser(name,email,password)
               _userRegistrationStatus.postValue(regResult)
           }catch (err:Exception){
              _userRegistrationStatus.postValue(Resource.Error(err.message?:"unknown error"))
           }

        }

    }
    fun loginUser(email: String, password: String){
        _userRegistrationStatus.postValue(Resource.Loading())
        viewModelScope.launch {
            try {
            val loginResults= userRepo.login(email, password)
                _userSignInStatus.postValue(loginResults)
            }catch (err:Exception){
                _userSignInStatus.postValue(Resource.Error(err.message?:"unknown error"))
            }
        }

    }
}