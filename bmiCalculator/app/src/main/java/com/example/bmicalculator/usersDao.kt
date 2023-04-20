package com.example.bmicalculator

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface usersDao {
    @Upsert
    fun insertUser(vararg users: users)

    @Query("SELECT heightft, heightin, MAX(heightTotal) FROM USERS")
    fun getTallest() : LiveData<List<users>>

    @Query("SELECT heightft, heightin, MIN(heightTotal) FROM USERS")
    fun getShortest() : LiveData<List<users>>

    @Query("SELECT AVG(bmi) FROM USERS")
    fun getAvgBmi() : LiveData<List<users>>
}