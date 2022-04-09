package com.fatherofapps.androidbase.data.services

import com.fatherofapps.androidbase.base.network.BaseRemoteService
import com.fatherofapps.androidbase.base.network.NetworkResult
import com.fatherofapps.androidbase.data.apis.JsonPlaceHolderApi
import com.fatherofapps.androidbase.data.modelJson.PostJson
import javax.inject.Inject

class JsonPlaceHolderRemoteService @Inject constructor(private  val jsonPlaceHolderApi: JsonPlaceHolderApi) : BaseRemoteService() {

    suspend fun getAllPosts(): NetworkResult<List<PostJson>>{
        return callApi { jsonPlaceHolderApi.getAllPost() }
    }

}