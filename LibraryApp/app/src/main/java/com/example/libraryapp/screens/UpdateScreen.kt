package com.example.libraryapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.libraryapp.room.BookEntity
import com.example.libraryapp.viewmodel.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(viewModel: BookViewModel, id: String?){
    var inputBook by remember {
        mutableStateOf("")
    }
    Column {
        OutlinedTextField(
            value = inputBook,
            onValueChange = { value ->
                inputBook = value
            },
            label = { Text(text = "Update Book Name") },
            placeholder = {
                Text(
                    text = "Enter new book name"
                )
            })
        OutlinedButton(
            onClick = {
                val book = BookEntity(id.toString().toInt(), inputBook)
                viewModel.updateBook(book)
                inputBook = ""
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text(text = "Submit")
        }
    }
}