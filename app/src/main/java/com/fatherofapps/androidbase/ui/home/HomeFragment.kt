package com.fatherofapps.androidbase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fatherofapps.androidbase.base.fragment.BaseFragment
import com.fatherofapps.androidbase.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {


    private lateinit var dataBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentHomeBinding.inflate(inflater)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        return dataBinding.root
    }


}