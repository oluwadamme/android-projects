package com.example.libraryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libraryapp.repository.BookRepository
import com.example.libraryapp.room.BookDB
import com.example.libraryapp.room.BookEntity
import com.example.libraryapp.ui.theme.LibraryAppTheme
import com.example.libraryapp.viewmodel.BookViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val cxt = LocalContext.current
                    val db = BookDB.getInstance(cxt)
                    val repository = BookRepository(db)
                    val viewModel = BookViewModel(repository)
                    MainScreen(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: BookViewModel) {

    var inputBook by remember {
        mutableStateOf("")
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
            label = { Text(text = "Book Name") },
            placeholder = {
                Text(
                    text = "Enter your book name"
                )
            })
        OutlinedButton(
            onClick = {
                val book = BookEntity(0, inputBook)
                viewModel.addBook(book)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text(text = "Submit")
        }

        BookList(viewModel  )


    }
}

@Composable
fun BookCard(viewModel: BookViewModel, book: BookEntity) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),modifier = Modifier.padding(start= 8.dp)) {
            Text(text = book.id.toString(), fontSize = 24.sp)
            Text(text = book.title, fontSize = 24.sp)
        }
    }
}

@Composable
fun BookList(viewModel: BookViewModel) {
    val books by viewModel.getBooks.collectAsState(initial = emptyList())
    LazyColumn(modifier = Modifier.padding(10.dp)) {
        items(books) { it ->
            BookCard(viewModel = viewModel, book = it)
        }
    }

}