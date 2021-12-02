package com.fatherofapps.androidbase.data.services

import com.fatherofapps.androidbase.data.database.daos.CustomerDao
import javax.inject.Inject

class CustomerLocalService @Inject constructor(private val customerDao: CustomerDao) {
}