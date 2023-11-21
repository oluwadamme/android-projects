package com.example.firstapplication


// open allows other class to inherit from it
open class Person(var name:String, var age:Int=0) {

    // secondary constructor
   // constructor( name:String,  age:Int=0)

    // this is called whenever an object of this class is called
     init{
        println("The Person name: $name")
        println("The Person age: $age")
    }

    var randField:String="Jame"

    // is equivalent to:
    get() = field //getter
    set(value)  {field=value} //setter

    fun talk(){
        println("$name is talking")
    }

    fun walk(){
        println("$name is walking")
    }

    fun eat(){
        println("$name is eating")
    }
}