package com.fatherofapps.androidbase.data.database.daos

import androidx.room.*
import com.fatherofapps.androidbase.data.database.entities.CustomerEntity

@Dao
interface CustomerDao {

    @Query("select * from customer")
   suspend fun getAll(): List<CustomerEntity>

   @Query("SELECT * FROM customer WHERE id = :id")
   suspend fun getCustomerById(id: Long): CustomerEntity

    @Insert
    suspend fun createCustomer(customerEntity: CustomerEntity): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCustomer(customerEntity: CustomerEntity)

    @Delete
    suspend fun deleteCustomer(customerEntity: CustomerEntity)
}