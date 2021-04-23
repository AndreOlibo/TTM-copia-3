package com.example.ttm.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "cliente")
data class Cliente(val nombre: String, val direccion: String, val email: String):BaseEntity() {

    override fun toString(): String {
        return "Cliente(nombre='$nombre', direccion=$direccion, email='$email')"
    }
}
