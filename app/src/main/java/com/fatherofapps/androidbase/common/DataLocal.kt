package com.fatherofapps.androidbase.common

import com.fatherofapps.androidbase.data.entities.Store

object DataLocal {
    var CUSTOMER_TOKEN = ""
    var IS_LOGGED_IN = ""
    var CURRENT_STORE_CODE = "all"
    var VERSION_API = "V1"
    var CURRENT_STORE: Store? = null
    var CURRENT_STORE_ID = 0
    var CURRENT_CUSTOMER_ID = -1
}