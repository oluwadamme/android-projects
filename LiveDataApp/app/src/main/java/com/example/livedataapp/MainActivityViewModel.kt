package com.example.livedataapp


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(private val startingNum: Int) : ViewModel() {

    private var total = MutableLiveData<Int>()
    val totalSum : LiveData<Int>
        get() = total


    init {
        total.value = startingNum
    }

    fun sumUp(value: Int) {
        total.value = (total.value)?.plus(value)
    }
}