package com.example.actorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.actorapp.model.Character
import com.example.actorapp.service.CharacterRepository
import com.example.actorapp.service.RetrofitInstance
import com.example.actorapp.ui.theme.ActorAppTheme
import com.example.actorapp.viewmodel.CharacterVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val characterApi = RetrofitInstance.provideApi(RetrofitInstance.provideRetrofit())
                    val repository= CharacterRepository(characterApi)
                    val viewModel=CharacterVM(repository)
                    MainScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel:CharacterVM) {
    val characters by viewModel.state.collectAsState()
    // filtering characters without image
    var filteredCharacters = mutableListOf<Character>()
    characters.forEach{
        if (it.image.isNotEmpty()){
            filteredCharacters.add(it)
        }
    }
    ActorsList(filteredCharacters)
}

@Composable
fun ActorsList(characters: List<Character>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {
        items(characters) { item ->
            CardItem(item)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardItem(item: Character) {
    Column( modifier = Modifier
        .padding(4.dp)) {
        GlideImage(
            model = item.image,
            contentDescription = "Image",
            modifier = Modifier
                .size(width = 120.dp, height = 140.dp)
        )
        Text(text = item.actorName, fontSize = 18.sp)
    }
}
