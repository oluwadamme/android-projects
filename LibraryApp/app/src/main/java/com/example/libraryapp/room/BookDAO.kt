package com.example.libraryapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

@Dao
interface BookDAO {
    @Insert
    suspend fun insertBook(book:BookEntity)

    @Update
    suspend fun updateBook(book:BookEntity)
}