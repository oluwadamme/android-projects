package com.example.firstapplication

abstract class Business {
    var brand="Ford"
    var year = 2023
    var color="Red"
    fun displayName(){
        println(brand)
    }
    // abstract functions don't have a body
    abstract fun displayColor()
}