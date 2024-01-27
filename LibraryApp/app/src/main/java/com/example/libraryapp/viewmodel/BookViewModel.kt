package com.example.libraryapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libraryapp.repository.BookRepository
import com.example.libraryapp.room.BookEntity
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository):ViewModel() {

    fun addBook(bookEntity: BookEntity){
        viewModelScope.launch {
            repository.addBookToRoom(bookEntity)
        }
    }
}