package com.example.ttm.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ttm.database.entities.Compra
import com.example.ttm.database.entities.Terminales

@Dao
interface CompraDao {

    @Query("SELECT * from compra")
    suspend fun findTodos(): List<Compra>

    @Query("SELECT * from compra where id=:idCompra")
    suspend fun findOneById(idCompra: Int): Compra

    @Update
    suspend fun update(compra: Compra)

    @Insert
    suspend fun save(compra: Compra): Long
}