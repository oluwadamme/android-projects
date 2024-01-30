package com.example.actorapp.service

import com.example.actorapp.model.Character
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getCharacter():List<Character>
}