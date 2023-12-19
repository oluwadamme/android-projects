package com.example.navigationapp

import android.os.Bundle
import android.text.TextPaint
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        //passing data from one fragment to another, we use bundle

        binding.btn.setOnClickListener() {
            val bundle = bundleOf("name" to binding.editText.text.toString())
            if (TextUtils.isEmpty(binding.editText.text.toString())) {
                Toast.makeText(context, "Field cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
            }
        }
        return binding.root
    }


}