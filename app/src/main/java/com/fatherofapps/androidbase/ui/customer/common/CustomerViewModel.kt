package com.fatherofapps.androidbase.ui.customer.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fatherofapps.androidbase.base.viewmodel.BaseViewModel
import com.fatherofapps.androidbase.data.models.Customer
import com.fatherofapps.androidbase.data.models.toCustomer
import com.fatherofapps.androidbase.data.repositories.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(private val customerRepository: CustomerRepository) :
    BaseViewModel() {

    private var _currentListCustomers = MutableLiveData<List<Customer>>()
    val currentListCustomer: LiveData<List<Customer>>
        get() = _currentListCustomers



    fun getAllCustomer() {
        showLoading(true)
        parentJob = viewModelScope.launch(handler) {
            val customers = customerRepository.getAllCustomers()
            _currentListCustomers.postValue(customers.map { it.toCustomer() })
        }
        registerJobFinish()
    }



}