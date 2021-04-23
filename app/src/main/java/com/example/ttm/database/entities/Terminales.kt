package com.example.ttm.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "terminales")
data class Terminales (val imagen: String, val marca: String, val modelo: String, val potencia: Double, val pixeles: Int, val precio: Double, var cantidad: Int):BaseEntity(){



    override fun toString(): String {
        return "Terminales(imagen='$imagen', marca='$marca', modelo='$modelo', potencia='$potencia', pixeles='$pixeles', precio='$precio', cantidad=$cantidad)"
    }
}

/*@Entity
data class Cliente (val nombre: String, val direccion: String, val email: String) {
    @PrimaryKey(autoGenerate = true)
    var idcliente: Long = 0

    override fun toString(): String {
        return "Cliente(nombre='$nombre', direccion=$direccion, email='$email')"
    }
}

@Entity
data class Compra (val id: Int, val idcliente: Int, val cantidad: Int) {


    override fun toString(): String {
        return "Compra(id='$id', idcliente=$idcliente, cantidad='$cantidad')"
    }
}*/