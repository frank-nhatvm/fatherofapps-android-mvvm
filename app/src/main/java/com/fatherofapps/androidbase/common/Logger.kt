package com.fatherofapps.androidbase.common

import android.util.Log
import com.fatherofapps.androidbase.BuildConfig

object Logger {

    fun log(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message)
        }
    }

}