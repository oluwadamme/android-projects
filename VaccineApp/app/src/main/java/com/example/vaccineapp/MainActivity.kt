package com.example.vaccineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. AdapterView: RecycleView
        val recyclerView:RecyclerView= findViewById(R.id.recycleView)
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        //2. data source
        val vaccineList = ArrayList<VaccineModel>()

        val v1 = VaccineModel("ASDD",R.drawable.ic_launcher_foreground)
        val v2 = VaccineModel("ASDD1",R.drawable.ic_launcher_foreground)
        val v3 = VaccineModel("ASDD2",R.drawable.ic_launcher_foreground)
        val v4 = VaccineModel("ASDD3",R.drawable.ic_launcher_foreground)
        val v5 = VaccineModel("4SDD",R.drawable.ic_launcher_foreground)
        val v6 = VaccineModel("ASDD5",R.drawable.ic_launcher_foreground)
        vaccineList.add(v1)
        vaccineList.add(v2)
        vaccineList.add(v3)
        vaccineList.add(v4)
        vaccineList.add(v5)
        vaccineList.add(v6)
        vaccineList.add(v6)
        vaccineList.add(v6)
        vaccineList.add(v6)
        vaccineList.add(v6)

        //3. My Adapter
        val adapter= MyAdapter(vaccineList)

        recyclerView.adapter=adapter
    }
}