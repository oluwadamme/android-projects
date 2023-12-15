package com.example.contactsmanagerapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1) // you can add as many entities you want
abstract class UserDatabase :RoomDatabase(){
    abstract val userDAO:UserDAO

    // Singleton : this is to create a single object at all time of class during the runtime
    //This is used for connecting the database to other components
    companion object{
        // this makes the field visible to other thread
        @Volatile
        private var INSTANCE:UserDatabase ?=null
        fun getInstance(context: Context):UserDatabase{
            synchronized(this){
                var instance= INSTANCE
                // Creating the database object if it is null
                if (instance==null){
                    instance=Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,"users_db").build()
                }
                return instance
            }

        }
    }
}