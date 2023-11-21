package com.example.luckyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.myToolbar))
        supportActionBar?.setDisplayShowTitleEnabled(true)

        val text1:TextView=findViewById(R.id.textView)
        val editText:EditText=findViewById(R.id.editText)
        val luckBtn:Button=findViewById(R.id.button)

        luckBtn.setOnClickListener(){
            val username=editText.text
            var intent:Intent= Intent(this, LuckNumberActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return true
    }
}