package com.example.ttm.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ttm.database.entities.Cliente
import com.example.ttm.database.entities.Compra
import com.example.ttm.database.entities.Terminales

@Dao
interface TerminalesDao {

    @Query("SELECT * from terminales")
    suspend fun findAll(): List<Terminales>

    @Query("SELECT * from terminales where modelo=:modeloTerminal")
    suspend fun findOneByModel(modeloTerminal: String): Terminales

    @Query("SELECT * from terminales where id=:idDispositivo")
    suspend fun findOneById(idDispositivo: Int): Terminales

    @Update
    suspend fun update(terminales: Terminales)

    @Insert
    suspend fun save(terminales: Terminales): Long

    @Query("SELECT * from terminales order by marca ASC")
    suspend fun findAllByMarca(): List<Terminales>

    @Query("SELECT * from terminales order by potencia ASC")
    suspend fun findOneByPotencia(): List<Terminales>

    @Query("SELECT * from terminales order by pixeles ASC")
    suspend fun findOneByPixeles(): List<Terminales>

    @Query("SELECT * from terminales order by modelo ASC")
    suspend fun findOneByPrecio(): List<Terminales>
}