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
        val customerId = if(id == -1L) 0 else id
        return CustomerEntity(
            id = customerId,
            firstName = firstName ?: "",
            lastName = lastName ?: "",
            shortDescription = shortDescription ?: "",
            stars = stars,
            certificates = certificates
        )
    }

    fun isValidateFirstName(): Boolean{
        return (firstName?.isNotEmpty() == true)
    }

    fun isValidateLastName():Boolean{
        return (lastName?.isNotEmpty() == true)
    }

    fun isValidateShortDescription(): Boolean{
        return (shortDescription?.isNotEmpty() == true)
    }

    fun isValidateData():Boolean{
        return isValidateFirstName() && isValidateLastName() && isValidateShortDescription()
    }

    fun fullName(): String{
        return "$firstName $lastName"
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