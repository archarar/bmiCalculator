package com.example.bmicalculator

import androidx.lifecycle.LiveData

class usersRepository(private val usersDao : usersDao) {

    suspend fun insertUser(users : users) {
        usersDao.insertUser(users)
    }

    val getTallest : LiveData<List<users>> = usersDao.getTallest()
    val getShortest : LiveData<List<users>> = usersDao.getShortest()
    val getAvgBmi : LiveData<List<users>> = usersDao.getAvgBmi()
}