package com.sareto.sarorientstore.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sareto.sarorientstore.R
import com.sareto.sarorientstore.databinding.FragmentProductHomeBinding
import com.sareto.sarorientstore.ui.base.BaseFragment

class ProductHomeFragment : BaseFragment<FragmentProductHomeBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentProductHomeBinding.inflate(inflater, container, false)


}