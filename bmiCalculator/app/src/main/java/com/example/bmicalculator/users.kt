package com.example.bmicalculator

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class users {
    @Entity
    data class USERS(
        @ColumnInfo(name = "heightft") val mHeightft : Double,
        @ColumnInfo(name = "heightin") val mHeightin : Double,
        @ColumnInfo(name = "heightTotal") val mHeightTotal : Double,
        @ColumnInfo(name = "neck") val mNeck : Double,
        @ColumnInfo(name = "waist") val mWaist : Double,
        @ColumnInfo(name = "bmi") val mBmi : Double,

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "ID") val mID : Int
    )
}