package com.example.viewpagerapp

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagerapp.fragments.FragmentOne
import com.example.viewpagerapp.fragments.FragmentThree
import com.example.viewpagerapp.fragments.FragmentTwo

class MyAdapter(mainActivity: MainActivity):FragmentStateAdapter(mainActivity) {

    private val fragment_size=3
    override fun getItemCount(): Int {
        return fragment_size
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 ->{
                return FragmentOne()
            }
            1 ->{
                return FragmentTwo()
            }
            2 ->{
                return FragmentThree()
            }
        }
        return FragmentOne()
    }
}