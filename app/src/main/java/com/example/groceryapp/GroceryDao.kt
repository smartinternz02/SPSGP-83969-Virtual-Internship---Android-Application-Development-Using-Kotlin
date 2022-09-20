package com.example.groceryapp

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.selects.select

@Dao
interface GroceryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item:GroceryItems)

    @Delete
    suspend fun delete(item:GroceryItems)

    @Query("SELECT * from grocery_items")
    fun getAllGroceryItems():LiveData<List<GroceryItems>>
}