package com.example.contactsmanagerapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsmanagerapp.R
import com.example.contactsmanagerapp.databinding.CardViewItemBinding
import com.example.contactsmanagerapp.room.User

class MyRecyclerViewAdapter(
    private val userList: List<User>,
    private val clickListener: (User) -> Unit
) :
    RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CardViewItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.card_view_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position], clickListener)
    }
}

class MyViewHolder(private val binding: CardViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User, clickListener: (User) -> Unit) {
        binding.nameTextField.text = user.name
        binding.emailTextField.text = user.email
        binding.cardLayout.setOnClickListener() {
            clickListener(user)
        }
    }

}