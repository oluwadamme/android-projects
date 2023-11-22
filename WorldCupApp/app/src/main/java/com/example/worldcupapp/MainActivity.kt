package com.example.worldcupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. AdapterView

        val listView:ListView= findViewById(R.id.listview)

        // 2. Adapter

        val adapter:MyAdapter= MyAdapter(this,generateData() )

        listView.adapter=adapter
        adapter.notifyDataSetChanged()

    }

    // 3. Data Source
   private fun generateData():ArrayList<CountryModel>{
        val result = ArrayList<CountryModel>()

        val country1 = CountryModel("Brazil","5",R.drawable.brazil)
        val country2 = CountryModel("France","4",R.drawable.france)
        val country3 = CountryModel("Germany","3",R.drawable.germany)
        val country4 = CountryModel("Saudi Arabia","2",R.drawable.saudiarabia)
        val country5 = CountryModel("Spain","1",R.drawable.spain)
        val country6 = CountryModel("United Kingdom","5",R.drawable.unitedkingdom)
        val country7 = CountryModel("United States","5",R.drawable.unitedstates)
        val country8 = CountryModel("United States","5",R.drawable.unitedstates)
        val country9 = CountryModel("United States","5",R.drawable.unitedstates)
        val country0 = CountryModel("United States","5",R.drawable.unitedstates)
        result.add(country1)
        result.add(country2)
        result.add(country3)
        result.add(country4)
        result.add(country5)
        result.add(country6)
        result.add(country7)
        result.add(country9)
        result.add(country8)
        result.add(country0)
        return  result
    }
}