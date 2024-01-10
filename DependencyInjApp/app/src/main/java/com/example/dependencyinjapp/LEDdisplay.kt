package com.example.dependencyinjapp

import android.util.Log
import com.mastercoding.myapplication.Display
import javax.inject.Inject

class LEDdisplay @Inject constructor() :Display {
    override fun turnOnScreen() {
        Log.i("TAGY", "Display Created")
    }
}