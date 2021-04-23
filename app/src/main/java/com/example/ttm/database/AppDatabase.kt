package com.example.ttm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ttm.application.App
import com.example.ttm.database.converters.Converters
import com.example.ttm.database.daos.ClientesDao
import com.example.ttm.database.daos.CompraDao
import com.example.ttm.database.daos.TerminalesDao
import com.example.ttm.database.entities.Cliente
import com.example.ttm.database.entities.Compra
import com.example.ttm.database.entities.Terminales
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Database(entities = arrayOf(Terminales::class, Cliente::class, Compra::class), version = 1)
@TypeConverters (Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun terminalesDao(): TerminalesDao
    abstract fun clientesDao(): ClientesDao
    abstract fun compraDao(): CompraDao


    companion object {
        private var instance: AppDatabase? = null
        private const val NAME_DB = "tienda_moviles"

        fun newInstance(context: Context):AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java, NAME_DB)
                        .addCallback(callback)
                        .build()
            }
            return instance!!
        }

        private val callback: Callback = object:Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                GlobalScope.launch {
                    withContext(Dispatchers.IO) {
                        App.obtenerDB().terminalesDao().save(Terminales("iphone12.png", "Apple", "Iphone 12 mini", 9.3, 12, 809.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("iphone12.png", "Apple", "Iphone 12", 9.4, 12, 909.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("iphone12pro.png", "Apple", "Iphone 12 Pro", 9.9, 12, 1159.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("iphone12pro.png", "Apple", "Iphone 12 Pro Max", 9.9, 12, 1159.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("galaxya72.png", "Samsung", "Galaxy A72", 7.4, 64, 449.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("galaxys21.png", "Samsung", "Galaxy S21", 9.0, 64, 1159.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("galaxynote.png", "Samsung", "Galaxy Note", 8.7, 108, 779.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("galaxyzfold2.png", "Samsung", "Galaxy Z Fold 2", 9.5, 12, 1699.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("mi10lite.png", "Xiaomi", "Mi 10T Lite", 7.2, 64, 249.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("mi10tpro.png", "Xiaomi", "Mi 10T Pro", 8.0, 108, 449.00, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("mi11lite.png", "Xiaomi", "Mi 11 Lite", 7.8, 64, 349.99, 10 ))
                        App.obtenerDB().terminalesDao().save(Terminales("mi11.png", "Xiaomi", "Mi 11", 8.2, 108, 749.99, 10 ))
                    }
                }
            }
        }
    }
    
}