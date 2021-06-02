package com.fatherofapps.androidbase.data.apis

import com.fatherofapps.androidbase.common.DataLocal
import com.fatherofapps.androidbase.data.entities.Store
import com.fatherofapps.androidbase.data.entities.StoreCurrency
import com.fatherofapps.androidbase.data.entities.StoreGroup
import com.fatherofapps.androidbase.data.entities.Website
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path

interface StoreAPI {

    @GET("{storeCode}/{versionRestAPI}/store/websites")
    suspend fun getListWebsites(
        @Path("storeCode") storeCode: String = DataLocal.CURRENT_STORE_CODE,
        @Path("versionRestAPI") versionRestAPI: String = DataLocal.VERSION_API,
        @HeaderMap headers: Map<String, String> = mapOf()
    ): Response<List<Website>>

    @GET("{storeCode}/{versionRestAPI}/store/storeGroups")
    suspend fun getStoreGroups(
        @Path("storeCode") storeCode: String = DataLocal.CURRENT_STORE_CODE,
        @Path("versionRestAPI") versionRestAPI: String = DataLocal.VERSION_API,
        @HeaderMap headers: Map<String, String> = mapOf()
    ): Response<List<StoreGroup>>

    @GET("{storeCode}/{versionRestAPI}/store/storeConfigs")
    suspend fun getStoreConfigs(
        @Path("storeCode") storeCode: String = DataLocal.CURRENT_STORE_CODE,
        @Path("versionRestAPI") versionRestAPI: String = DataLocal.VERSION_API,
        @HeaderMap headers: Map<String, String> = mapOf()): Response<List<Store>>

    @GET("{storeCode}/{versionRestAPI}/directory/currency")
    suspend fun getCurrency(
        @Path("storeCode") storeCode: String = DataLocal.CURRENT_STORE_CODE,
        @Path("versionRestAPI") versionRestAPI: String = DataLocal.VERSION_API,
        @HeaderMap headers: Map<String, String> = mapOf()): Response<StoreCurrency>

}