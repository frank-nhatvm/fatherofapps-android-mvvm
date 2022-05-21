package com.fatherofapps.androidbase.ui.customer.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.fatherofapps.androidbase.base.fragment.BaseFragment
import com.fatherofapps.androidbase.common.EventObserver
import com.fatherofapps.androidbase.databinding.FragmentRegisterBinding
import com.fatherofapps.androidbase.ui.customer.common.CustomerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment() {

    private lateinit var dataBinding: FragmentRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()
    private val args by navArgs<RegisterFragmentArgs>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetch(args.id)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentRegisterBinding.inflate(inflater,container,false)
        dataBinding.lifecycleOwner  = viewLifecycleOwner
        dataBinding.registerViewModel = viewModel
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.addCustomerSuccess.observe(viewLifecycleOwner,EventObserver{
            isSuccess ->
            if(isSuccess){
                findNavController().popBackStack()
            }
        })
    }


}