package com.fatherofapps.androidbase.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fatherofapps.androidbase.data.database.daos.CustomerDao
import com.fatherofapps.androidbase.data.database.entities.CustomerEntity

@Database(entities = [CustomerEntity::class],version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun customerDao(): CustomerDao
}