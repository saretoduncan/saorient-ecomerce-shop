package com.sareto.sarorientstore.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sareto.sarorientstore.R
import com.sareto.sarorientstore.databinding.FragmentSignupBinding
import com.sareto.sarorientstore.ui.base.BaseFragment


class SignupFragment : BaseFragment<FragmentSignupBinding>()  {
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
        TODO("Not yet implemented")
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentSignupBinding.inflate(inflater, container, false)

}