package com.example.retrofitapp

import AlbumService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView:TextView= findViewById(R.id.text)
        val retrofitInstance=RetrofitInstance.retrofitInstance().create(AlbumService::class.java)

        val responseLiveData:LiveData<Response<Albums>> = liveData {
           // val response= retrofitInstance.getAllAlbums()
            val response= retrofitInstance.getAllAlbumsByUserID(5)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null){
                while (albumList.hasNext()){
                    val album =albumList.next()
//                    Log.i("TAGY",album.title)
                    val result="Album Title: ${album.title}\n"
                    textView.append(result)
                }
            }
        })
    }
}