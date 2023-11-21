package com.example.explicitintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn:Button = findViewById(R.id.button)

        btn.setOnClickListener(){
            //Explicit Intent
            var i =Intent(this, Activity2::class.java)

            // Passing data to the next activity
            i.putExtra("data","love")

            startActivity(i)
        }

        // Implicit intent - to use the components of an external application
        val  btn1:Button=findViewById(R.id.button1)
        btn1.setOnClickListener(){
            // this intent will open a web browser
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://etrack.africa"))
            startActivity(intent)
        }

    }
}