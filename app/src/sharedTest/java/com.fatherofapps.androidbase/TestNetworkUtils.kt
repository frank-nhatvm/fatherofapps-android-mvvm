package com.fatherofapps.androidbase


import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody

object TestNetworkUtils {

    fun createBody(code: Int, body: String): ResponseBody?{
        return okhttp3.Response.Builder().code(code).protocol(Protocol.HTTP_1_1)
            .message("fail").request(Request.Builder().url("http://localhost/").build()).body(
                body.toResponseBody("application/json; charset=utf-8".toMediaType())
            )
            .build().body
    }


}