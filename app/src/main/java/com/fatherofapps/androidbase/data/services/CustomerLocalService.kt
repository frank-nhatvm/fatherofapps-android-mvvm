package com.fatherofapps.androidbase.data.services

import com.fatherofapps.androidbase.data.database.daos.CustomerDao
import com.fatherofapps.androidbase.data.database.entities.CustomerEntity
import javax.inject.Inject

class CustomerLocalService @Inject constructor(private val customerDao: CustomerDao) {

    suspend fun getAllCustomers() {
        customerDao.getAll()
    }

    suspend fun createCustomer(customerEntity: CustomerEntity){
        customerDao.createCustomer(customerEntity)
    }

    suspend fun updateUser(customerEntity: CustomerEntity){
        customerDao.updateCustomer(customerEntity)
    }

    suspend fun deleteCustomer(customerEntity: CustomerEntity){
        customerDao.deleteCustomer(customerEntity)
    }

}