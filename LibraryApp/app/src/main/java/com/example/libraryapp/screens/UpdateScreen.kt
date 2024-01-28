package com.example.libraryapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.libraryapp.room.BookEntity
import com.example.libraryapp.viewmodel.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(viewModel: BookViewModel, id: String?, navController: NavController) {
    var inputBook by remember {
        mutableStateOf("")
    }
    var hintBook by remember {
        mutableStateOf("")
    }
    val books by viewModel.getBooks.collectAsState(initial = emptyList())
    if (books.isNotEmpty()){
        for (book in books){
            if (book.id==id!!.toInt()){
                hintBook=book.title
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        OutlinedTextField(
            value = inputBook,
            onValueChange = { value ->
                inputBook = value
            },
            label = { Text(text = "Update Book Name") },
            placeholder = {
                Text(
                    text = hintBook
                )
            })
        OutlinedButton(
            onClick = {
                val book = BookEntity(id.toString().toInt(), inputBook)
                viewModel.updateBook(book)
                inputBook = ""
                navController.popBackStack("MainScreen",inclusive = false)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text(text = "Update")
        }
    }
}