package com.example.tablayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayoutapp.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val tabArray= arrayOf("Games","Movies","Books")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager:ViewPager2= findViewById(R.id.view_pager)
        val tabLayout:TabLayout=findViewById(R.id.tab_layout)

        val myAdapter= ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager.adapter=myAdapter

        // Connecting tab layout with view pager
        TabLayoutMediator(tabLayout,viewPager){
            tab, position->tab.text=tabArray[position]
        }.attach()
    }
}