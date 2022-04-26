package com.fatherofapps.androidbase.data.models

import com.fatherofapps.androidbase.data.database.entities.CustomerEntity


class Customer(
    val id: Long = -1,
    var firstName: String? = null ,
    var lastName:String? = null ,
    var shortDescription: String? = null,
    var stars: Float = 0f,
    var certificates: String? = null
){
    fun toCustomerEntity(): CustomerEntity{
        return CustomerEntity(
            firstName = firstName ?: "",
            lastName = lastName ?: "",
            shortDescription = shortDescription ?: "",
            stars = stars,
            certificates = certificates
        )
    }
}

fun CustomerEntity.toCustomer(): Customer{
    return Customer(
        id  = id,
        firstName = firstName,
        lastName = lastName,
        shortDescription = shortDescription,
        stars = stars,
        certificates = certificates
    )
}