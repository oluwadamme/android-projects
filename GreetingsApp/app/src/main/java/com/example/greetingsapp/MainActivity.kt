package com.example.greetingsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var count:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt:EditText=findViewById(R.id.edt)
        val btn:Button=findViewById(R.id.btn)

        btn.setOnClickListener {
            var text = edt.text
            Toast.makeText(this,"Hello "+ text,Toast.LENGTH_LONG).show()
        }

        val txt:TextView=findViewById(R.id.count_result)
        val btn1:Button=findViewById(R.id.btn1)
        btn1.setOnClickListener(){
            count++
            txt.setText(""+count)

        }

    }
}