package com.example.myfirstcompose

import android.graphics.Paint
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcompose.ui.theme.MyFirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayContainer()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayContainer() {

    val itemList = bottomList()
    var selectedItem by remember {
        mutableStateOf("Home")
    }
    var cxt = LocalContext.current.applicationContext
    Box() {
        Scaffold(
            contentWindowInsets = WindowInsets(top = 60.dp),
            topBar = {
                TopAppBar(
                    title = { Text(text = "New Topbar") },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = ""
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = ""
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Cyan)
                )
            },
            bottomBar = {
                NavigationBar(
                    modifier = Modifier.fillMaxWidth(),
                    content = {
                        itemList.forEach { item ->
                            NavigationBarItem(
                                label = { Text(text = item.name) },
                                icon = {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = ""
                                    )
                                },
                                onClick = { selectedItem = item.name },
                                selected = (selectedItem == item.name)
                            )
                        }

                    },
                )

            },

            ) { innerPadding ->
            ScrollContent(innerPadding)
        }
    }


}

private fun bottomList(): List<BottomMenuItem> {
    val itemList = arrayListOf<BottomMenuItem>()
    itemList.add(BottomMenuItem("Home", Icons.Filled.Home))

    itemList.add(BottomMenuItem("Phone", Icons.Filled.Phone))
    itemList.add(BottomMenuItem("Cart", Icons.Filled.ShoppingCart))
    itemList.add(BottomMenuItem("Settings", Icons.Filled.Settings))
    return itemList
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    val context = LocalContext.current.applicationContext

    var count by remember {
        mutableStateOf(0)
    }
    var enteredValue by remember {
        mutableStateOf("")
    }
    var isAbove18 by remember {
        mutableStateOf(false)
    }
    var radioOptions = listOf("A", "B", "C")
    var selected by remember {
        mutableStateOf(radioOptions[0])
    }
    Column(
        modifier = Modifier
            .padding(innerPadding).padding(horizontal = 20.dp)
            .background(color = Color.Cyan),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        Text(
            text = stringResource(id = R.string.app_name), style = TextStyle(
                color = Color.Blue,
                fontSize = 22.sp,
                textDecoration = TextDecoration.LineThrough
            )
        )

        Button(
            onClick = {
//                Toast.makeText(context, "You clicked here", Toast.LENGTH_SHORT).show()

                count++
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Click me  $count")

        }
        Image(
            painter = painterResource(id = R.drawable.image), contentDescription = "just image",
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
        )

        TextField(
            value = enteredValue,
            onValueChange = { value -> enteredValue = value },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .align(Alignment.CenterHorizontally),
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Enter your name") },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    isAbove18 = validateAge(enteredValue)
                }
            ),

            isError = isAbove18,

            )
        if (!isAbove18) {
            Text(
                text = "Youre above 18",
                color = MaterialTheme.colorScheme.error,


                )
        }

        Column(modifier = Modifier.selectableGroup()) {
            radioOptions.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (selected == it),
                            onClick = { selected = it },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selected == it,
                        onClick = { selected = it },
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Text(text = it)
                }

            }
        }
    }
}

private fun validateAge(inputText: String): Boolean {
    return inputText.toInt() < 18
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeTheme {
        Greeting("Android")
    }
}