package com.example.firstapplication

import java.util.Scanner
import kotlin.math.absoluteValue

fun main() {


//    var c1 = Car(year = 2023, brand = "BMW", color = "Red") // create a c1 object of the Car class
//    var c2 = Car("RANGE",2022, "BLUE")
//    // accessing the attributes of class
//   println( c1.brand)
//
//var c1=Color()
//    println(c1.displayColor())

    //Immutable List :Read elements only
//    var list1 = listOf<String>("A","b","D")
//    list1.forEach {s: String ->  println(s) }

    //Mutable List: read and modify elements
//    var mutList = mutableListOf<Int>(1,2,3,4)
//    mutList.add(3, 5)
//    println(mutList)

    //Immutable Map
//    var immMap= mapOf(1 to "dammy", 2 to "joey",3 to "gdjsd")
//    for ( value in immMap.values){
//        println(value)
//    }

    //Mutable map
//    var mutMap= mutableMapOf<String,Int>("sammy" to 1, "dammy" to 4)
//    mutMap.put("joy", 3)
//    println(mutMap)


    // Exercise 1
//    var s1 = Scanner(System.`in`);
//    println("Please the numerator")
//    var x= s1.nextInt()
//    println("Please the denominator")
//    var y= s1.nextInt()
//
//    fun divideTwoNumber( x:Int, y:Int){
//        if (y==0) {
//            println("Cannot divide by Zero")
//            return
//        }
//        var divisor = (x/y);
//        var remainder = x%y
//        println("$x divided by $y is $divisor remainder $remainder")
//    }
//    divideTwoNumber(x,y)

    // Exercise : Reverse a string
//    var s1 = Scanner(System.`in`)
//    print("Please the text: \n")
//    var text = s1.nextLine()
//    var res:String =""
//    for (ch in text.toCharArray().reversed()){
//        res += ch
//    }
//    println(res)

//    var s1 = Scanner(System.`in`)
//   print("Please the 1st text: \n")
//    var x = s1.nextInt()
//    print("Please the 2nd text: \n")
//    var y = s1.nextInt()
//    print("Please the 3rd text: \n")
//     var z = s1.nextInt()
//   var  result = arrayListOf<Int>(x,y,z)
//    println("Max number: ${result.max()}")

  // Lambda
  //1. With parameter & with return value
//  val add1: (Int, Int)-> Int={a:Int,b:Int->a+b}
//  println(add1(3,4))
//
//  //2. With parameter & without no return value
//  val add2:(Int, Int)-> Unit={a:Int, b:Int-> println(a+b) }
//  add2(2,7)

//  //3. No parameter & With return value
//  val add3:()-> String={"sjshbfsfs sjbsd"}
//  println(add3())


  var number = listOf<Int>(1,2,3,4,5)
  println(number.filter { number ->number>3 })
  println(number.filter { it >3 }) // Using "it" keyword



}