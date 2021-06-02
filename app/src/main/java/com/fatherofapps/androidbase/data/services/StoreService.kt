package com.fatherofapps.androidbase.data.services

import com.fatherofapps.androidbase.base.network.BaseService
import com.fatherofapps.androidbase.base.network.NetworkHelper
import com.fatherofapps.androidbase.base.network.NetworkResult
import com.fatherofapps.androidbase.data.apis.StoreAPI
import com.fatherofapps.androidbase.data.entities.Store
import com.fatherofapps.androidbase.data.entities.StoreCurrency
import com.fatherofapps.androidbase.data.entities.StoreGroup
import com.fatherofapps.androidbase.data.entities.Website
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StoreService @Inject constructor(private val storeAPI: StoreAPI) : BaseService() {

    suspend fun getStoreConfig(): Flow<NetworkResult<List<Store>>> = flow {
        emit(callApi {
            storeAPI.getStoreConfigs(headers = NetworkHelper.getDefaultHeader())
        })
    }

    suspend fun getStoreCurrency(): Flow<NetworkResult<StoreCurrency>> = flow {
        emit(callApi {
            storeAPI.getCurrency(headers = NetworkHelper.getDefaultHeader())
        })
    }

    suspend fun getListWebsite(): Flow<NetworkResult<List<Website>>> = flow {

        emit(callApi(call = {
            storeAPI.getListWebsites(headers = NetworkHelper.getDefaultHeader())
        }))
    }

    suspend fun getListStoreGroups(): Flow<NetworkResult<List<StoreGroup>>> = flow {

        emit(callApi(call = {
            storeAPI.getStoreGroups(headers = NetworkHelper.getDefaultHeader())
        }))
    }

}