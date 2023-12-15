package com.example.contactsmanagerapp.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsmanagerapp.room.User
import com.example.contactsmanagerapp.room.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel(), Observable {

    val users = repository.users
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: User

    // this annotation should be apply to any getter accessor method of any observable class
    // Bindable will generate a field in the B-R class to identify the field that has changed
    @Bindable
    var inputName = MutableLiveData<String?>()

    @Bindable
    var inputEmail = MutableLiveData<String?>()

    @Bindable
    var saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    var clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        if (isUpdateOrDelete) {
            //Make changes:
            userToUpdateOrDelete.name = inputName.value!!
            userToUpdateOrDelete.email = inputEmail.value!!
            update(userToUpdateOrDelete)

        } else {
            val name = inputName.value!!
            val email = inputEmail.value!!

            insert(User(0, name, email))

            inputEmail.value = null
            inputName.value = null
        }


    }

    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(userToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun update(user: User) = viewModelScope.launch {
        repository.update(user)
        // Resetting variables
        inputEmail.value = null
        inputName.value = null
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
        isUpdateOrDelete = false

    }

    fun delete(user: User) = viewModelScope.launch {
        repository.delete(user)
        // Resetting variables
        inputEmail.value = null
        inputName.value = null
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
        isUpdateOrDelete = false
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    fun initUpdateAndDelete(selectedItem: User) {
        isUpdateOrDelete = true
        inputEmail.value = selectedItem.email
        inputName.value = selectedItem.name
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
        userToUpdateOrDelete = selectedItem
    }
}