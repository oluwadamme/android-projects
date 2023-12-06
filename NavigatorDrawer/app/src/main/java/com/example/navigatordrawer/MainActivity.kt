package com.example.navigatordrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout= findViewById(R.id.drawer_layout)
        toggle=ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open,
            R.string.close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // this is to ensure home fragment is enabled
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // navigation functionality

        val navView:NavigationView= findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener {
            it.isChecked=true
            when(it.itemId){
                R.id.home_page -> {
                    replaceFragment(HomeFragment(),it.title.toString())
                }
                R.id.settings -> {
                    replaceFragment(SettingsFragment(),it.title.toString())
                }
                R.id.login -> {
                    replaceFragment(LoginFragment(),it.title.toString())
                }
                R.id.message -> {
                    replaceFragment(MessageFragment(),it.title.toString())
                }
            }
            true
        }
    }

    private  fun replaceFragment(fragment: Fragment,title:String){
        val fragTrans:FragmentTransaction=supportFragmentManager.beginTransaction()
        fragTrans.replace(R.id.frame_layout_1,fragment).commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return  true
        }
        return super.onOptionsItemSelected(item)
    }

}