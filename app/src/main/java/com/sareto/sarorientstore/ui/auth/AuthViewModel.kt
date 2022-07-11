package com.sareto.sarorientstore.ui.auth

import androidx.lifecycle.ViewModel
import com.sareto.sarorientstore.data.repositories.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AuthViewModel(private val repository: UserRepository):ViewModel() {
    // email and password input
    var email:String?= null
    var password:String?= null

    //auth listener
    var authListener:AuthListener?= null
    //disposable to dispose the  the compatible
    private val disposables = CompositeDisposable()

    val user by lazy {
        repository.currentUser()
    }
    //login
    fun login (){
        if(email.isNullOrBlank()|| password.isNullOrBlank()) {
            authListener?.onFailure("Invalid Email Or Password")
            return
        }
        authListener?.onStarted()
        //calling login from repository to perform actual authentication
        val disposable = repository.login(email!!, password!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                //send a success callback
                authListener?.onSuccess()
            },{
                authListener?.onFailure(it.message!!)
            })
        disposables.add(disposable)
    }
    //signup
    fun signup(){
        if(email.isNullOrBlank() || password.isNullOrBlank()){
            authListener?.onFailure("please input all values")
            return

        }
        authListener?.onStarted()
        val disposable= repository.signup(email!!, password!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                authListener?.onSuccess()
            },{
                authListener?.onFailure(it.message!!)
            })
        disposables.add(disposable)
    }
    //disposing the disposables
    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}