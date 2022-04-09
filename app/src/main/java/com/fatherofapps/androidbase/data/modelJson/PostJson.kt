package com.fatherofapps.androidbase.data.modelJson

import com.fatherofapps.androidbase.data.models.Post

class PostJson(
 val userId: Int?,
 val id: Int?,
 val title: String?,
 val body: String?
){
    fun toPost() : Post{
        return Post(
            userId = userId,
            id = id,
            title = title,
            body = body
        )
    }
}
