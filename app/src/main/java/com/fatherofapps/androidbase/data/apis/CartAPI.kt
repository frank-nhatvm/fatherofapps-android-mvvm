package com.fatherofapps.androidbase.data.apis

import com.fatherofapps.androidbase.common.DataLocal
import retrofit2.Response
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path

interface CartAPI {

    @POST("{storeCode}/{versionRestAPI}/carts/mine")
    suspend fun createAnEmptyCart(
        @Path("storeCode") storeCode: String = DataLocal.CURRENT_STORE_CODE,
        @Path("versionRestAPI") versionRestAPI: String = DataLocal.VERSION_API,
        @HeaderMap headers: Map<String, String> = mapOf()
    ): Response<String>



}