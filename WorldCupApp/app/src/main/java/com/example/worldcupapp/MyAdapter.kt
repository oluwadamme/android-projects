package com.example.worldcupapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(private var activity: Activity, private var items:ArrayList<CountryModel>):BaseAdapter() {
    override fun getCount(): Int {
      return items.size
    }

    override fun getItem(position: Int): CountryModel {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       var view:View?
       var viewHolder:ViewHolder

       if (convertView==null){
           //Dynamic way of defining a UI layout
           val inflatter = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

           // inflate means display
            view= inflatter.inflate(R.layout.list_tile,null)
           viewHolder=ViewHolder(view)
           view?.tag=viewHolder
       }else{
           // convertView is for recycling. it is used to build new UI that jumps on the screen whil scrolling
           view=convertView
           viewHolder= view.tag as ViewHolder
       }

        val country = items[position]
        viewHolder.txtName?.text= country.name
        viewHolder.imgFlag?.setImageResource(country.imgFlag)
        viewHolder.txtTrophy?.text=country.trophy
        view?.setOnClickListener(){
            Toast.makeText(activity,"You choose: ${country.name}",Toast.LENGTH_SHORT).show()
        }
        return  view as View
    }


    // This is to initialize the widget created in the layout
    private class ViewHolder(row:View?){
        var txtName:TextView?=null
        var txtTrophy:TextView?=null
        var imgFlag:ImageView?=null

        init {
            this.imgFlag=row?.findViewById(R.id.imageView)
            this.txtName=row?.findViewById(R.id.countryName)
            this.txtTrophy=row?.findViewById(R.id.trophy)
        }
    }

}