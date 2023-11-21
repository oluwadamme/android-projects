package com.example.viewsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.viewsapp.R.*
import com.example.viewsapp.ui.theme.ViewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        // declaring a widget
        val textview:TextView =findViewById(R.id.textView20)
        textview.setText("Rate my skill friends")

        val emailEditText:EditText=findViewById(R.id.editTextEmail)

        val text= emailEditText.text
        println(text)

        // Button event
        val btn:Button=findViewById(R.id.button)
        btn.setOnClickListener() {
            Toast.makeText(this@MainActivity,text,Toast.LENGTH_LONG).show()
        }
        val img:ImageView=findViewById(R.id.image)

    }
}