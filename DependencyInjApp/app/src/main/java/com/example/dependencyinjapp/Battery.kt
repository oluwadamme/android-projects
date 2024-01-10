package com.mastercoding.myapplication

import android.util.Log
import javax.inject.Inject


// instance where by this class is from a 3rd party library and it can't be modified

class Battery{
    init {
        Log.i("TAGY", "Battery Created")
    }

    fun displayBatteryPower(){
        Log.i("TAGY", "Battery is 100%")
    }
}