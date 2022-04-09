package com.fatherofapps.androidbase.data.modelJson

import com.fatherofapps.androidbase.data.models.Question
import com.squareup.moshi.Json

data class QuestionItemsJson(
    val items: List<Question>?,
    @Json(name =  "has_more") val hasMore: Boolean? = false
)
