package com.example.ttm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ttm.application.App
import com.example.ttm.database.entities.Cliente
import com.example.ttm.database.entities.Compra
import com.example.ttm.database.entities.Terminales
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ClienteViewModel  : ViewModel() {
    val db = App.obtenerDB()

    fun save(cliente: Cliente) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.clientesDao().save(cliente)
            }
        }
    }


    fun restarStock (idDispositivo: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val terminal = App.obtenerDB().terminalesDao().findOneById(idDispositivo)
                terminal.cantidad = terminal.cantidad - 1
                App.obtenerDB().terminalesDao().update(terminal)
            }
        }


        /*viewModelScope.launch {
            val compra = withContext(Dispatchers.IO) {
                db.clientesDao().findOneByName(nombre)
            }
            liveData.postValue(cliente)
        }
        return liveData*/
    }
}