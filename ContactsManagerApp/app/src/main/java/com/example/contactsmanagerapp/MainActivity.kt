package com.example.contactsmanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsmanagerapp.viewModel.UserViewModel
import com.example.contactsmanagerapp.viewModel.UserViewModelFactory
import com.example.contactsmanagerapp.adapters.MyRecyclerViewAdapter
import com.example.contactsmanagerapp.databinding.ActivityMainBinding
import com.example.contactsmanagerapp.room.User
import com.example.contactsmanagerapp.room.UserDAO
import com.example.contactsmanagerapp.room.UserDatabase
import com.example.contactsmanagerapp.room.UserRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var factory: UserViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao: UserDAO = UserDatabase.getInstance(this).userDAO
        val repository = UserRepository(dao)
        factory = UserViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        viewModel.users.observe(this, Observer {
            binding.recyclerView.adapter=MyRecyclerViewAdapter(it,{selectedItem:User->listItemClicked(selectedItem)})
        })
    }

    private fun listItemClicked(selectedItem: User) {
        Toast.makeText(this,"Selected name is ${selectedItem.name}",Toast.LENGTH_SHORT).show()
    viewModel.initUpdateAndDelete(selectedItem)
    }
}