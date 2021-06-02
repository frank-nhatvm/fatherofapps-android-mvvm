package com.fatherofapps.androidbase.di

import com.fatherofapps.androidbase.BuildConfig
import com.fatherofapps.androidbase.data.apis.*

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideCartAPI(@Named("MainSite") retrofit: Retrofit): CartAPI{
      return retrofit.create(CartAPI::class.java)
    }

    @Provides
    fun provideCategoryAPI(@Named("MainSite") retrofit: Retrofit): CategoryAPI{
        return retrofit.create(CategoryAPI::class.java)
    }

    @Provides
    fun provideCountryAPI(@Named("MainSite") retrofit: Retrofit): CountryAPI{
        return retrofit.create(CountryAPI::class.java)
    }

    @Provides
    fun provideCustomerAPI(@Named("MainSite") retrofit: Retrofit): CustomerAPI {
        return retrofit.create(CustomerAPI::class.java)
    }

    @Provides
    fun provideProductAPI(@Named("MainSite") retrofit: Retrofit): ProductAPI {
        return retrofit.create(ProductAPI::class.java)
    }

    @Provides
    fun provideStoreAPI(@Named("MainSite") retrofit: Retrofit): StoreAPI {
        return retrofit.create(StoreAPI::class.java)
    }



    @Provides
    @Singleton
    @Named("MainSite")
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder().addConverterFactory(moshiConverterFactory)
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @Named("FatherOfApps")
    fun provideRetrofitNewYorkTime(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder().addConverterFactory(moshiConverterFactory)
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOKHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.interceptors().add(httpLoggingInterceptor)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): MoshiConverterFactory {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return MoshiConverterFactory.create(moshi)
    }

}