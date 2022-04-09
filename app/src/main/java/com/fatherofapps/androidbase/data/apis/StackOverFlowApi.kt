package com.fatherofapps.androidbase.data.apis

import com.fatherofapps.androidbase.data.modelJson.QuestionItemsJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface StackOverFlowApi {

    @GET("{versionRestAPI}/questions/")
    suspend fun getQuestions(
        @Path("versionRestAPI") versionRestAPI: String = "2.2",
        @QueryMap parameters: Map<String, String> = mapOf()
    ): Response<QuestionItemsJson>

}