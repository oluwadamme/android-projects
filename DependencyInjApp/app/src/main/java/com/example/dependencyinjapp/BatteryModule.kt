package com.example.dependencyinjapp

import com.mastercoding.myapplication.Battery
import dagger.Module
import dagger.Provides


// for 3rd party packages
@Module
class BatteryModule {
    @Provides
    fun providesBattery():Battery{
        return Battery()
    }
}