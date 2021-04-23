package com.example.ttm.database.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*

abstract class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo(name = "create_at")
    var createAt: Date = Date(System.currentTimeMillis())

    @ColumnInfo(name = "update_at")
    var update: Date = Date(System.currentTimeMillis())
}