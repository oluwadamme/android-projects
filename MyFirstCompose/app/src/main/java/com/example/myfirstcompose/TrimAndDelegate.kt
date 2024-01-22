package com.example.myfirstcompose

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class TrimAndDelegate :ReadWriteProperty<Any?,String> {
    private var trimString = ""
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return trimString
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
       trimString="Hi ${value.trim()}"
    }
}