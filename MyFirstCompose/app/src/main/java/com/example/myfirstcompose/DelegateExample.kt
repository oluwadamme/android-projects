package com.example.myfirstcompose

// by keyword is used to delegate properties
private var stringOne by TrimAndDelegate()
fun main() {
    stringOne = "Hadbaj    "
    println(stringOne)
}