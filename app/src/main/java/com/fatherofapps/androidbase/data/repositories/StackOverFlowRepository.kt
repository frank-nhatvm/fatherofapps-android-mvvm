package com.fatherofapps.androidbase.data.repositories

import com.fatherofapps.androidbase.base.network.NetworkResult
import com.fatherofapps.androidbase.data.services.StackOverFlowRemoteService
import com.fatherofapps.androidbase.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StackOverFlowRepository @Inject constructor(
    private val stackOverFlowRemoteService: StackOverFlowRemoteService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend fun getQuestion(page:Int, pageSize:Int) = withContext(dispatcher){
        when(val result = stackOverFlowRemoteService.getQuestions(page, pageSize)){
            is NetworkResult.Success -> {
                result.data
            }
            is NetworkResult.Error -> {
                throw  result.exception
            }
        }
    }

}