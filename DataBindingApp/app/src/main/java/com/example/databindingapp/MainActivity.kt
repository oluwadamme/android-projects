package com.example.databindingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // this is to inflate(display)our widgets (activities)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        factory = MainActivityViewModelFactory(20)
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)
//        val u1=User("Jack","12345")
//        binding.user=u1
        binding.textView.text = viewModel.getCounter().toString()
        binding.apply {

            button.setOnClickListener() {
//                val value = editText.text.toString()
//                textView.setText("You entered: $value")
                textView.text = viewModel.updateCount().toString()
            }
        }


    }
}