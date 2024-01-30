package com.example.actorapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.actorapp.model.Character
import com.example.actorapp.service.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterVM(private val characterRepository: CharacterRepository) :ViewModel(){
    private val _state= MutableStateFlow(emptyList<Character>())
    val state: StateFlow<List<Character>>
        get() = _state
    init {
        viewModelScope.launch {
            val characters=characterRepository.getCharacters()
            _state.value=characters
        }
    }
}