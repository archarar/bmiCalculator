package com.example.bmicalculator

import androidx.lifecycle.LiveData

class usersRepository(private val usersDao : usersDao) {

    suspend fun insertUser(user: user) {
        usersDao.insertUser(user)
    }

    val getTallest : LiveData<List<user>> = usersDao.getTallest()
    val getShortest : LiveData<List<user>> = usersDao.getShortest()
    val getAvgBmi : LiveData<List<user>> = usersDao.getAvgBmi()
}