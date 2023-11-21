package com.example.luckyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luck_number)
        val luckyNum: TextView =findViewById(R.id.luckyNum)
        val shareBtn:Button=findViewById(R.id.shareBtn)
        var name=getUsername()
        var number = generateRandNumber()

        luckyNum.setText(""+number)

        shareBtn.setOnClickListener(){
            shareData(name, number)
        }
    }

   private fun getUsername():String{
        var bundle:Bundle?=intent.extras
        var username=bundle?.get("username")
        return  username.toString()
    }
    private fun generateRandNumber():Int{
        var random= Random.nextInt(1000)
        return random
    }

    //Sharing result
    private fun shareData(username:String,number:Int){

        //Implict intent
        var intent= Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_SUBJECT,"$username is lucky today")
        intent.putExtra(Intent.EXTRA_TEXT,"Your luck number is $number")

        startActivity(intent)

    }

}