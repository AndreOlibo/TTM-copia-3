package com.example.ttm.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*


@Entity(tableName = "compra")
data class Compra (@ColumnInfo(name = "id_cliente") val idCliente: Int, val cantidad: Int):BaseEntity() {

    override fun toString(): String {
        return "Compra(idcliente=$idCliente, cantidad='$cantidad')"
    }
}
