package com.example.bmicalculator

import androidx.room.Entity
import androidx.room.PrimaryKey

// create the USERS table and its schema
@Entity(tableName = "USERS")
data class user(
    val heightft : Double,
    val heightin : Double,
    val heightTotal : Double,
    val neck : Double,
    val waist : Double,
    val bmi : Double,

    @PrimaryKey(autoGenerate = true)
    val id : Int
)