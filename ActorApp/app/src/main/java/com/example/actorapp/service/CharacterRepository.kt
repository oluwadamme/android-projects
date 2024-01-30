package com.example.actorapp.service
import com.example.actorapp.model.Character
class CharacterRepository(private val characterApi: CharacterApi) {

    suspend fun getCharacters():List<Character>{
      return  characterApi.getCharacter()
    }
}