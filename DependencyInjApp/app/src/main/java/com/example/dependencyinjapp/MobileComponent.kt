package com.mastercoding.myapplication

import com.example.dependencyinjapp.BatteryModule
import com.example.dependencyinjapp.LEDdisplayModule
import com.example.dependencyinjapp.MainActivity
import dagger.Component
@Component(modules = [BatteryModule::class, LEDdisplayModule::class])
interface MobileComponent {

   // fun getMobileComponent():Mobile
  //  incase we have several dependencies, we do this instead

    fun inject(mainActivity: MainActivity)

}