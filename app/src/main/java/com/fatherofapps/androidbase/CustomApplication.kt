package com.fatherofapps.androidbase

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CustomApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Log.e("Frank","CustomerApplication")
    }

}