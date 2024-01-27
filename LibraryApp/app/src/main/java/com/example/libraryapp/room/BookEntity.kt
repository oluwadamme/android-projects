package com.example.libraryapp.room

import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title: String
)
