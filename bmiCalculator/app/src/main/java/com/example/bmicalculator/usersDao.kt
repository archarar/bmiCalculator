package com.example.bmicalculator

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface usersDao {

    // function to insert a new user and update the table
    @Upsert
    fun insertUser(vararg user: user)

    // query to get the height of the tallest user
    @Query("SELECT heightin, heightft, MAX(heightTotal) AS heightTotal, neck, waist, bmi, id FROM USERS")
    fun getTallest() : LiveData<List<user>>

    // query to get the height of the shortest user
    @Query("SELECT heightin, heightft, MIN(heightTotal) AS heightTotal, neck, waist, bmi, id FROM USERS")
    fun getShortest() : LiveData<List<user>>

    // query to get the average bmi
    @Query("SELECT heightin, heightft, heightTotal, neck, waist, AVG(bmi) AS bmi, id FROM USERS")
    fun getAvgBmi() : LiveData<List<user>>
}