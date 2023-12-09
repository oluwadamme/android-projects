package com.example.databindingapp

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingNum: Int) : ViewModel() {
    private var counter = 0

    init {
        counter = startingNum
    }

    fun getCounter(): Int {
        return counter
    }

    fun updateCount(): Int {
        return counter++
    }
}