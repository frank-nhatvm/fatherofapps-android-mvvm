package com.fatherofapps.androidbase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.fatherofapps.androidbase.R
import com.fatherofapps.androidbase.base.fragment.BaseFragment
import com.fatherofapps.androidbase.data.models.Customer
import com.fatherofapps.androidbase.databinding.FragmentHomeBinding
import com.fatherofapps.androidbase.ui.customer.common.CustomerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {


    private lateinit var dataBinding: FragmentHomeBinding
    private val customerViewModel by activityViewModels<CustomerViewModel>()
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentHomeBinding.inflate(inflater)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        customerViewModel.getAllCustomer()
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataBinding.btnNewCustomer.setOnClickListener {
            openCustomerScreen()
        }

        val itemListener = object : HomeAdapter.HomeAdapterItemListener{
            override fun onClickItem(customer: Customer) {
                openCustomerScreen(customer.id)
            }
        }
        adapter = HomeAdapter(itemListener)
        dataBinding.rcvCustomers.adapter = adapter

        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        dataBinding.rcvCustomers.layoutManager = layoutManager

        AppCompatResources.getDrawable(requireContext(), R.drawable.home_divider)?.let { drawable ->
            val itemDecoration = DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL)
            itemDecoration.setDrawable(drawable)
            dataBinding.rcvCustomers.addItemDecoration(itemDecoration)
        }

        customerViewModel.currentListCustomer.observe(viewLifecycleOwner){
            list ->
            adapter.submitList(list)
        }

    }

    private fun openCustomerScreen(id: Long = -1L) {
        val action = HomeFragmentDirections.actionHomeFragmentToRegisterFragment(id)
        findNavController().navigate(action)
    }

}