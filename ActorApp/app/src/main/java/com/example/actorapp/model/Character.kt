package com.example.actorapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(
    @Json(name = "actor")
    val actorName: String,
    val image: String
)
