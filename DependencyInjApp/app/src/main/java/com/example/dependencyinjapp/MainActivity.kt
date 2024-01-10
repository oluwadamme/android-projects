package com.example.dependencyinjapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mastercoding.myapplication.DaggerMobileComponent
import com.mastercoding.myapplication.Mobile
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
     lateinit var mobile: Mobile
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // this is to make the class reusable in other activities
(application as MobileApplication).mobileComponent.inject(this)
    }
}