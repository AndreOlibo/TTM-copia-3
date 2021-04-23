package com.example.ttm.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Terminales")
data class Producto(val marca:String, val modelo:String, val potencia:String, val pixeles:String, val precio: Double) {

    var id: Long = -1

    constructor(id: Long, marca:String, modelo:String, potencia: String, pixeles: String, precio: Double) : this (marca, modelo, potencia, pixeles, precio) {
        this.id = id
    }

    override fun toString(): String {
        return "Producto(id=$id, marca=$marca, modelo=$modelo, potencia=$potencia, pixeles=$pixeles, precio=$precio, id=$id)"
    }


}