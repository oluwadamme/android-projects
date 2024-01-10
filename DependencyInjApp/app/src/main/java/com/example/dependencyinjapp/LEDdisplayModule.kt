package com.example.dependencyinjapp

import com.mastercoding.myapplication.Display
import dagger.Module
import dagger.Provides

@Module
class LEDdisplayModule(val resolution:Int) {

    @Provides
    fun providesLEDdisplay():Display{
        return LEDdisplay()
    }
}