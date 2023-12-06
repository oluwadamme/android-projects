package com.example.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button =findViewById(R.id.button1)
        val btn2: Button =findViewById(R.id.button2)

        btn1.setOnClickListener(){
            val fragment1:Fragment=Fragment1()
            val franTrans:FragmentTransaction=supportFragmentManager.beginTransaction()

            // This is to replace the frame 1 with the custom fragment created
            franTrans.replace(R.id.frame1,fragment1).commit()
        }

        btn2.setOnClickListener(){
            val fragment2:Fragment=Fragment2()
            val franTrans:FragmentTransaction=supportFragmentManager.beginTransaction()

            // This is to replace the frame 1 with the custom fragment created
            franTrans.replace(R.id.frame1,fragment2).commit()
        }
    }
}