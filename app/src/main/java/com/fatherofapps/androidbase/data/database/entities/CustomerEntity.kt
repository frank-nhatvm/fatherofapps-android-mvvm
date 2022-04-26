package com.fatherofapps.androidbase.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer")
data class CustomerEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = -1,
    @ColumnInfo(name ="first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName:String,
    @ColumnInfo(name= "short_description") val shortDescription: String,
    @ColumnInfo val stars: Float = 0f,
    @ColumnInfo val certificates: String? = null
)