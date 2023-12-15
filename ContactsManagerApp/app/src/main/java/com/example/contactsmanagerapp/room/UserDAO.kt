package com.example.contactsmanagerapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface UserDAO {
   // a suspend function is a keyword that is used to executing along running operation and
   // wait for it without interruption i.e paused or resumed at any time
    // suspend functions are run in the background thread
   @Insert
   suspend fun insertUser(user: User):Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    // Creating custom SQL query
    @Query("DELETE from user")
    suspend fun deleteAll()

    @Query("SELECT * from user")
    fun getAllUserFromDB():LiveData<List<User>>
}