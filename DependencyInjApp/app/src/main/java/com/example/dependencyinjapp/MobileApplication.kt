package com.example.dependencyinjapp

import android.app.Application
import com.mastercoding.myapplication.DaggerMobileComponent
import com.mastercoding.myapplication.MobileComponent

class MobileApplication:Application() {
lateinit var mobileComponent: MobileComponent
    override fun onCreate() {
     mobileComponent=   initDagger()
        super.onCreate()
    }

    private fun initDagger():MobileComponent=   DaggerMobileComponent.builder().lEDdisplayModule(LEDdisplayModule(1800))
        .build()


}