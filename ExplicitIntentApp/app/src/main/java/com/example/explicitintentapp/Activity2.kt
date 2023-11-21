package com.example.explicitintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        // receiving data from previous activity
        val bundle: Bundle?=intent.extras
        val data = bundle?.get("data")

        Toast.makeText(this, "Data from previous activity is $data",Toast.LENGTH_LONG).show()
    }
}