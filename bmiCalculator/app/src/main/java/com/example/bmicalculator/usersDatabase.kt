package com.example.bmicalculator

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [user::class], version = 1, exportSchema = false)
abstract class usersDatabase : RoomDatabase() {

    abstract fun usersDao() : usersDao

    companion object {
        @Volatile
        private var INSTANCE : usersDatabase? = null

        fun getDatabase(context : Context) : usersDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    usersDatabase::class.java,
                    "USERS"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}