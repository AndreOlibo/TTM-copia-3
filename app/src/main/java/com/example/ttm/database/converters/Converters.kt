package com.example.ttm.database.converters

import androidx.room.TypeConverter
import java.util.*

class Converters  {
    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(date: Long): Date {
        return Date(date)
    }
}