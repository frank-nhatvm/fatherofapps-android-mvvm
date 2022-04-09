package com.fatherofapps.androidbase.data.apis

import com.fatherofapps.androidbase.data.modelJson.PostJson
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    @GET("/posts")
    suspend fun getAllPost(): Response<List<PostJson>>

}