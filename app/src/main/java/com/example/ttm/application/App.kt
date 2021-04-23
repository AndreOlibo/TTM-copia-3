package com.example.ttm.application

import android.app.Application
import com.example.ttm.database.AppDatabase

class App:Application(){

    companion object {
        private var db: AppDatabase? = null
        fun obtenerDB(): AppDatabase {
            return db!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        db = AppDatabase.newInstance(applicationContext)
    }
}