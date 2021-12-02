package com.fatherofapps.androidbase.data.repositories

import com.fatherofapps.androidbase.data.services.CustomerLocalService
import com.fatherofapps.androidbase.data.services.CustomerRemoteService
import com.fatherofapps.androidbase.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher

class CustomerRepository constructor(
    private val customerRemoteService: CustomerRemoteService,
    private val customerLocalService: CustomerLocalService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
}