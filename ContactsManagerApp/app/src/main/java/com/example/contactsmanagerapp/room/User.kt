package com.example.contactsmanagerapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user") // This is to tag it that it will acts as an entity.
// If the table name is not specific, the class name will be used
data class User(
    @PrimaryKey(autoGenerate = true) // Auto generate the id
    @ColumnInfo(name = "user_id")
    var id:Int,

    @ColumnInfo(name = "user_name")
    var name:String,

    @ColumnInfo(name = "user_email") // this is to specify the column name. by default, room will use the variable name specified
    var email:String)
