package com.example.simplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Adapter View : ListView
        val listView:ListView= findViewById(R.id.listview)

        // 2. Data source: Array of objects
        val listOfCountries= arrayOf("Germany","Brazil","Spain","England","Qatar")

        // 3. Adapter
        var arrayAdapter:ArrayAdapter<*>

        // using inbuilt layout
//        arrayAdapter= ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, listOfCountries
//        )

        // using custom layout
        arrayAdapter= ArrayAdapter(this, R.layout.list_item,R.id.textView,listOfCountries)
        // connecting the data to the UI
        listView.adapter=arrayAdapter
    }
}