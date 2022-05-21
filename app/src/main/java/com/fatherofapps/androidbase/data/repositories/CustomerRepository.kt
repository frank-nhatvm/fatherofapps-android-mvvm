package com.fatherofapps.androidbase.data.repositories

import com.fatherofapps.androidbase.data.database.daos.CustomerDao
import com.fatherofapps.androidbase.data.database.entities.CustomerEntity
import com.fatherofapps.androidbase.data.services.CustomerLocalService
import com.fatherofapps.androidbase.data.services.CustomerRemoteService
import com.fatherofapps.androidbase.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CustomerRepository @Inject constructor(
    private val customerDao: CustomerDao,
    private val customerLocalService: CustomerLocalService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend fun getCustomerById(id: Long) = withContext(dispatcher){
        customerDao.getCustomerById(id)
    }

    suspend fun getAllCustomers() = withContext(dispatcher) {
        customerDao.getAll()
    }

    suspend fun createCustomer(customerEntity: CustomerEntity)= withContext(dispatcher) {
        customerDao.createCustomer(customerEntity)
    }

    suspend fun updateUser(customerEntity: CustomerEntity)= withContext(dispatcher) {
        customerDao.updateCustomer(customerEntity)
    }

    suspend fun deleteCustomer(customerEntity: CustomerEntity)= withContext(dispatcher) {
        customerDao.deleteCustomer(customerEntity)
    }

}