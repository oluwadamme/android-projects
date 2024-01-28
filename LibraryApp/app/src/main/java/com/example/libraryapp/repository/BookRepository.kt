package com.example.libraryapp.repository

import com.example.libraryapp.room.BookDB
import com.example.libraryapp.room.BookEntity

class BookRepository(private val bookDB: BookDB) {

    suspend fun addBookToRoom(bookEntity: BookEntity){
        bookDB.bookDao().insertBook(bookEntity);
    }

    suspend fun deleteBookToRoom(bookEntity: BookEntity){
        bookDB.bookDao().deleteBook(bookEntity);
    }

    suspend fun updateBookToRoom(bookEntity: BookEntity){
        bookDB.bookDao().updateBook(bookEntity);
    }

    fun getAllBooks()= bookDB.bookDao().getAllBooks()


}