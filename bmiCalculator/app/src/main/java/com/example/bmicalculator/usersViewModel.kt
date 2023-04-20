package com.example.bmicalculator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class usersViewModel(application: Application) : AndroidViewModel(application) {

    private val getTallest : LiveData<List<users>>
    private val getShortest : LiveData<List<users>>
    private val getAvgBmi : LiveData<List<users>>
    private val repository : usersRepository

    init {
        val usersDao = usersDatabase.getDatabase(application).usersDao()
        repository = usersRepository(usersDao)
        getTallest = repository.getTallest
        getShortest = repository.getShortest
        getAvgBmi = repository.getAvgBmi
    }

    fun insertUser(users : users) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(users)
        }
    }

}