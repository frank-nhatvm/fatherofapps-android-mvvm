package com.fatherofapps.androidbase.common

import android.app.Activity
import com.fatherofapps.androidbase.CustomApplication

val Activity.customApplication: CustomApplication
get() = application as CustomApplication