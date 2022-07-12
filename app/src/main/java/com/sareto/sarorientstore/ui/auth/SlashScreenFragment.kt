package com.sareto.sarorientstore.ui.auth

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sareto.sarorientstore.R
import com.sareto.sarorientstore.databinding.FragmentSlashScreenBinding
import com.sareto.sarorientstore.ui.base.BaseFragment


class SlashScreenFragment : BaseFragment<FragmentSlashScreenBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_loginScreen)
        }, 4000)
    }
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentSlashScreenBinding.inflate(inflater, container, false);

}