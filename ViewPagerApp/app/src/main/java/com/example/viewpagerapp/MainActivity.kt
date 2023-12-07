package com.example.viewpagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    private val arrayList=ArrayList<String>()
    lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager=findViewById(R.id.view_pager)
        myAdapter=MyAdapter(this)

        viewPager.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.adapter=myAdapter
    }
}