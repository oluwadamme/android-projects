package com.example.tablayoutapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayoutapp.fragments.BooksFragment
import com.example.tablayoutapp.fragments.GamesFragment
import com.example.tablayoutapp.fragments.MoviesFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {

    val fragmentSize=3
    override fun getItemCount(): Int {
       return  fragmentSize

    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return GamesFragment()
            1 -> return MoviesFragment()
        }
        return BooksFragment()
    }
}