package com.example.livedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        factory = MainActivityViewModelFactory(20)
        viewModel = ViewModelProvider(this,factory).get(MainActivityViewModel::class.java)

        //Observing for data change
        viewModel.totalSum.observe(this, Observer{

            binding.result.text=it.toString()
        })

        binding.button.setOnClickListener(){
            viewModel.sumUp(binding.editText.text.toString().toInt())
        }
    }
}