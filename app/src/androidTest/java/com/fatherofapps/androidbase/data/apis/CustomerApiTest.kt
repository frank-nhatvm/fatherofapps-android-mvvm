package com.fatherofapps.androidbase.data.apis

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fatherofapps.androidbase.common.Logger
import com.google.common.truth.Truth
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.json.JSONObject
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class CustomerApiTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var mockServer: MockWebServer

    private lateinit var countryAPI: CustomerAPI

    @Before
    fun setup() {
        mockServer = MockWebServer()
        mockServer.start()
        val url = mockServer.url("/")
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val moshiConverter = MoshiConverterFactory.create(moshi)

        val retrofit = Retrofit.Builder().addConverterFactory(moshiConverter)
            .baseUrl(url)
            .build()

        countryAPI = retrofit.create(CustomerAPI::class.java)
    }

    @After
    fun stopService() {
        mockServer.shutdown()
    }


    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap(), responseCode: Int = 200) {

        val inputStream = javaClass.classLoader!!
            .getResourceAsStream(fileName)

        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(responseCode)
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        mockServer.enqueue(
            mockResponse
                .setBody(source.readString(Charsets.UTF_8))
        )
    }


//    @Test
//    fun getListCountries_fail_returns_an_error() = runBlocking{
//        enqueueResponse("countryapi/getListCountries_error.json",responseCode = 400)
//
//        val response = countryAPI.getListCountries()
//
//        Truth.assertThat(response.isSuccessful).isFalse()
//
//        val data = response.errorBody()?.string() ?: ""
//        Truth.assertThat(data).isNotNull()
//        val jsonError = JSONObject(data)
//        Truth.assertThat(jsonError.has("message")).isTrue()
//        val message = jsonError.getString("message")
//        Truth.assertThat(message).isEqualTo("Specified request cannot be processed.")
//    }

}