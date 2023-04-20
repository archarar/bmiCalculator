package com.example.bmicalculator

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface usersDao {
    @Upsert
    fun insertUser(vararg user: user)

    @Query("SELECT heightin, heightft, MAX(heightTotal) AS heightTotal, neck, waist, bmi, id FROM USERS")
    fun getTallest() : LiveData<List<user>>

    @Query("SELECT heightin, heightft, MIN(heightTotal) AS heightTotal, neck, waist, bmi, id FROM USERS")
    fun getShortest() : LiveData<List<user>>

    @Query("SELECT heightin, heightft, heightTotal, neck, waist, AVG(bmi) AS bmi, id FROM USERS")
    fun getAvgBmi() : LiveData<List<user>>
}