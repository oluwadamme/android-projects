package com.example.coroutineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.coroutineapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var counter =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.countBtn.setOnClickListener(){
            counter++
            binding.countText.text=counter.toString()
        }
        binding.downloadBtn.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {
                // suspend function can only be called in a coroutine
                downloadFileFromNet()
            }

        }

        // running coroutine in parallel

        CoroutineScope(Dispatchers.IO).launch{
          val one=async {
              doSomething1()
          }
           val two =async {
               doSomething2()
           }
            val result=one.await()+two.await()
            Log.v("Tagy","Result is $result")
        }
    }

    // we use suspend function to prevent thread blocking and provide smooth exprience
    // in your app

    private suspend fun downloadFileFromNet() {
        for (i in 1..100000){
            Log.i("TAGY","Downloading $i in ${Thread.currentThread().name}")
            // this is to switch from background thread(IO) to main thread. this is because the
            // view is in the main thread
            withContext(Dispatchers.Main){
                binding.downloadText.text=" $i in ${Thread.currentThread().name}"
            }

        }
    }

    private suspend fun doSomething1() : Int{
        delay(7000)
        Log.v("Tagy", "Fun1 is done")
        return 11
    }

    private suspend fun doSomething2() : Int{
        delay(6000)
        Log.v("Tagy", "Fun2 is done")
        return 18
    }
}