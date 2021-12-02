package com.fatherofapps.androidbase.base.network

import retrofit2.Response

class BaseRemoteService : BaseService() {

    protected suspend fun <T : Any> callApi(call: suspend () -> Response<T>): NetworkResult<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (t: Throwable) {
            return NetworkResult.Error(parseNetworkErrorException(t))
        }

        return if (response.isSuccessful) {
            if (response.body() == null) {
                NetworkResult.Error(BaseNetworkException(responseMessage =  "Response without body", responseCode = 200))
            } else {
                NetworkResult.Success(response.body()!!)
            }
        } else {
            val errorBody = response.errorBody()?.string() ?: ""
            NetworkResult.Error(parseError(response.message(), response.code(), errorBody))
        }
    }

}