package com.sareto.sarorientstore.ui.auth

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sareto.sarorientstore.R
import com.sareto.sarorientstore.databinding.FragmentSlashScreenBinding
import com.sareto.sarorientstore.ui.base.BaseFragment


class SlashScreenFragment : BaseFragment<FragmentSlashScreenBinding>() {
    private lateinit var auth: FirebaseAuth
    private  var currentUser:FirebaseUser? = null
    override fun onStart() {
        super.onStart()
        auth = Firebase.auth
        this.currentUser = auth.currentUser
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            if(this.currentUser!=null) Navigation.findNavController(view).navigate(R.id.action_splashScreen_to_loginScreen)
            else Toast.makeText(activity,"${currentUser?.email} is already logged in", Toast.LENGTH_LONG).show()
        }, 5000)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentSlashScreenBinding.inflate(inflater, container, false);

}