package com.sareto.sarorientstore.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sareto.sarorientstore.R
import com.sareto.sarorientstore.data.utility.Resource
import com.sareto.sarorientstore.databinding.FragmentLoginBinding
import com.sareto.sarorientstore.ui.base.BaseFragment
import com.sareto.sarorientstore.ui.products.ProductsMainActivity
import com.sareto.sarorientstore.ui.viewModels.AuthViewModel


class LoginFragment : BaseFragment<FragmentLoginBinding>() {
   private val  authViewModel:AuthViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpLogin.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
        binding.loginButton.setOnClickListener{
            login()//login
        }
    }
    private fun initializeViewModels(){
//        authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]//initialize auth view model
    }
    private fun login(){
        val email= binding.edLoginEmail.text.toString().trim()
        val password= binding.edLoginPassword.text.toString().trim()
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edLoginEmail.error="Invalid Email Address"
            return
        }
        if(password.isEmpty()){
            binding.edLoginPassword.error= "Please enter Your password"
            return
        }
        authViewModel.loginUser(email,password)
        authViewModel.userSignInStatus.observe(viewLifecycleOwner, Observer{
            when(it){
                is Resource.Loading->{
                    Log.d("login......","loading")
                }
                is Resource.Success ->{
                    val intent = Intent(requireActivity(), ProductsMainActivity::class.java)
                    startActivity(intent)
                }
               is Resource.Error -> {
                   Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
               }
            }
        })

    }


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentLoginBinding.inflate(inflater, container,false)



}