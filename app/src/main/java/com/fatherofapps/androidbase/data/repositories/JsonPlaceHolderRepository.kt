package com.fatherofapps.androidbase.data.repositories

import com.fatherofapps.androidbase.base.network.NetworkResult
import com.fatherofapps.androidbase.data.services.JsonPlaceHolderRemoteService
import com.fatherofapps.androidbase.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class JsonPlaceHolderRepository @Inject constructor(private  val jsonPlaceHolderRemoteService: JsonPlaceHolderRemoteService,
@IoDispatcher private val dispatcher: CoroutineDispatcher
                                                    ) {

    suspend fun getAllPost() = withContext(dispatcher){
        when(val result = jsonPlaceHolderRemoteService.getAllPosts()){
            is NetworkResult.Success -> {
                result.data.map { it.toPost() }
            }
            is NetworkResult.Error -> {
                throw  result.exception
            }
        }
    }


}