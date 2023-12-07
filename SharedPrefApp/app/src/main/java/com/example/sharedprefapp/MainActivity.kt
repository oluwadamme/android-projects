package com.example.sharedprefapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var userName:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText:EditText= findViewById(R.id.editText)
        userName=findViewById(R.id.saved_name)
        val btn:Button=findViewById(R.id.button)
        readFromSharedPref()
        btn.setOnClickListener(){
            val inputField= editText.text.toString()
            saveToSharedPref(inputField)

        }

    }

    private fun saveToSharedPref(inputField: String) {
        // Opening the SharedPreference file
        val pref:SharedPreferences=getSharedPreferences("UserName", MODE_PRIVATE)
        // writing to pref
        val editor:SharedPreferences.Editor=pref.edit()

        editor.putString("name",inputField).apply()
    }

    private fun readFromSharedPref(){
        // Opening the SharedPreference file
        val pref:SharedPreferences=getSharedPreferences("UserName", MODE_PRIVATE)

        val s1:String? =pref.getString("name","")
        userName.setText(s1)
    }
}