package com.example.ttm.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ttm.database.entities.Cliente
import com.example.ttm.database.entities.Terminales

@Dao
interface ClientesDao {

    @Query("SELECT * from cliente")
    suspend fun findAl(): List<Cliente>

    @Query("SELECT * from cliente where nombre=:nombreCliente")
    suspend fun findOneByName(nombreCliente: String): Cliente

    @Update
    suspend fun update(cliente: Cliente)

    @Insert
    suspend fun save(cliente: Cliente): Long
}