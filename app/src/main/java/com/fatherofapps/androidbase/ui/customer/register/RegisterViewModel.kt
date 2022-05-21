package com.fatherofapps.androidbase.ui.customer.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fatherofapps.androidbase.base.viewmodel.BaseViewModel
import com.fatherofapps.androidbase.common.Event
import com.fatherofapps.androidbase.common.EventObserver
import com.fatherofapps.androidbase.data.models.Customer
import com.fatherofapps.androidbase.data.models.toCustomer
import com.fatherofapps.androidbase.data.repositories.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val customerRepository: CustomerRepository) :
    BaseViewModel() {


    private var _addCustomerSuccess = MutableLiveData<Event<Boolean>>()
    val addCustomerSuccess: LiveData<Event<Boolean>>
        get() = _addCustomerSuccess

    private var _currentCustomer = MutableLiveData<Customer?>()
    val currentCustomer: LiveData<Customer?>
        get() = _currentCustomer

    fun fetch(id: Long) {
        if (id == -1L) {
            _currentCustomer.postValue(Customer())
        } else {
            getCustomerById(id)
        }
    }

    private fun getCustomerById(id: Long) {
        showLoading(true)
        parentJob = viewModelScope.launch(handler) {
            val customerEntity = customerRepository.getCustomerById(id)
            _currentCustomer.postValue(customerEntity.toCustomer())
        }
        registerJobFinish()
    }


    private fun addNewCustomer(customer: Customer) {
        showLoading(true)
        parentJob = viewModelScope.launch(handler) {
            val customerEntity = customer.toCustomerEntity()
            customerRepository.createCustomer(customerEntity)
            _addCustomerSuccess.postValue(Event(true))
        }
        registerJobFinish()
    }

    fun registerAction() {
        currentCustomer.value?.let { customer ->
            addNewCustomer(customer)
        }
    }


    fun onFirstnameChanged(
        text: CharSequence?,
        start: Int,
        before: Int,
        count: Int
    ) {
        val firstName = text?.toString()
        val customer = currentCustomer.value
        if (customer?.firstName != firstName) {
            customer?.firstName = firstName
            _currentCustomer.postValue(customer)
        }
    }

    fun onLastnameChanged(  text: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int){
        val customer = currentCustomer.value
        val lastname = text?.toString()
        if(customer?.lastName != lastname){
            customer?.lastName = lastname
            _currentCustomer.postValue(customer)
        }
    }

    fun onShortDescriptionChanged(  text: CharSequence?,
                                    start: Int,
                                    before: Int,
                                    count: Int){
        val customer = currentCustomer.value
        val shortDescription = text?.toString()
        if(customer?.shortDescription != shortDescription){
            customer?.shortDescription == shortDescription
            _currentCustomer.postValue(customer)
        }
    }


}