package com.fatherofapps.androidbase

import android.app.Application
import com.fatherofapps.androidbase.di.DaggerAppComponent

public class CustomApplication : Application(){

    open val appComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}