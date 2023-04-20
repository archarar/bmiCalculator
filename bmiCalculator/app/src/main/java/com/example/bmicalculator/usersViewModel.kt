package com.example.bmicalculator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class usersViewModel(application: Application) : AndroidViewModel(application) {

    val getTallest : LiveData<List<user>>
    val getShortest : LiveData<List<user>>
    val getAvgBmi : LiveData<List<user>>
    private val repository : usersRepository

    init {
        val usersDao = usersDatabase.getDatabase(application).usersDao()
        repository = usersRepository(usersDao)
        getTallest = repository.getTallest
        getShortest = repository.getShortest
        getAvgBmi = repository.getAvgBmi
    }

    fun insertUser(newUser: user) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(newUser)
        }
    }

}