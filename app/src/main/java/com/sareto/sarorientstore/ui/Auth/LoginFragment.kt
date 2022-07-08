package com.sareto.sarorientstore.ui.Auth

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sareto.sarorientstore.R
import com.sareto.sarorientstore.databinding.FragmentLoginBinding
import com.sareto.sarorientstore.ui.base.BaseFragment


class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpLogin.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
        binding.loginButton.setOnClickListener{
            login()//login
        }
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
    }


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentLoginBinding.inflate(inflater, container,false)



}