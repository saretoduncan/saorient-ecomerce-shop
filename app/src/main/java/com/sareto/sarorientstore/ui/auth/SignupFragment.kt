package com.sareto.sarorientstore.ui.auth

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sareto.sarorientstore.R
import com.sareto.sarorientstore.databinding.FragmentSignupBinding
import com.sareto.sarorientstore.ui.base.BaseFragment
import com.sareto.sarorientstore.ui.viewModels.AuthViewModel


class SignupFragment : BaseFragment<FragmentSignupBinding>()  {
    private val authViewModel:AuthViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        binding.signupButton.setOnClickListener{
            signup()//signup button
        }
    }

    private fun signup() {
       val fullNames: String = binding.edFirstName.text.toString().trim()
        val email = binding.edEmail.text.toString().trim()
        val password = binding.edSignupPassword.text.toString().trim()
        val confirmPassword = binding.edConfirmPassword.text.toString().trim()
        if(fullNames.isEmpty()){
            binding.edFirstName.error="please enter your name"
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.edEmail.error="Invalid Email Address"
            return
        }
        if(password.isEmpty()){
            binding.edSignupPassword.error= "Please enter Your password"
            return
        }
        if(password != confirmPassword){
            binding.edConfirmPassword.error="password doesn't match"
            return
        }

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentSignupBinding.inflate(inflater, container, false)

}