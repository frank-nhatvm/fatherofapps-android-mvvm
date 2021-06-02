package com.fatherofapps.androidbase.data.entities

import com.squareup.moshi.Json

data class Store(
    @Json(name = "id") val storeId: Int,
    @Json(name = "code") val code: String,
    @Json(name = "website_id") val websiteId: Int,
    @Json(name = "locale") val locale: String?,
    @Json(name = "base_currency_code") val baseCurrencyCode: String = "",
    @Json(name = "default_display_currency_code") val defaultDisplayCurrencyCode: String = "",
    @Json(name = "timezone") val timezone: String?,
    @Json(name = "weight_unit") val weightUnit: String?,
    @Json(name = "base_url") val baseUrl: String = "",
    @Json(name = "base_link_url") val baseLinkUrl: String?,
    @Json(name = "base_static_url") val baseStaticUrl: String?,
    @Json(name = "base_media_url") val baseMediaUrl: String = "",
    @Json(name = "secure_base_url") val secureBaseUrl: String?,
    @Json(name = "secure_base_link_url") val secureBaseLinkUrl: String?,
    @Json(name = "secure_base_static_url") val secureBaseStaticUrl: String?,
    @Json(name = "secure_base_media_url") val secureBaseMediaUrl: String?
)

data class Website(
    @Json(name = "id") val id: Int,
    @Json(name = "code") val code: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "default_group_id") val defaultGroupId: String?
)

data class StoreGroup(
    @Json(name = "id") val id: Int,
    @Json(name = "website_id") val websiteId: Int,
    @Json(name = "default_store_id") val defaultStoreId: Int
)

data class StoreCurrency(
    @Json(name = "base_currency_code") val baseCurrencyCode: String?
)