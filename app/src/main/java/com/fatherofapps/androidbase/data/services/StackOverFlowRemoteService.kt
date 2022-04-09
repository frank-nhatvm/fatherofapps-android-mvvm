package com.fatherofapps.androidbase.data.services

import com.fatherofapps.androidbase.base.network.BaseRemoteService
import com.fatherofapps.androidbase.base.network.NetworkResult
import com.fatherofapps.androidbase.data.apis.StackOverFlowApi
import com.fatherofapps.androidbase.data.modelJson.QuestionItemsJson
import javax.inject.Inject

class StackOverFlowRemoteService @Inject constructor(private val stackOverFlowApi: StackOverFlowApi) : BaseRemoteService() {

    suspend fun getQuestions(page:Int, pageSize:Int): NetworkResult<QuestionItemsJson>{
        val parameters = mutableMapOf<String,String>()
        parameters["page"] = page.toString()
        parameters["pageSize"] = pageSize.toString()
        parameters["site"] = "stackoverflow"
        return  callApi { stackOverFlowApi.getQuestions(parameters = parameters) }
    }

}