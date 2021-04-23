package com.example.ttm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ttm.application.App
import com.example.ttm.database.entities.Terminales
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TerminalesViewmodel : ViewModel() {
    val db = App.obtenerDB()

    fun save(terminales: Terminales) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.terminalesDao().save(terminales)
            }
        }
    }

    fun stock (modelo: String): LiveData<Terminales> {
        val liveData = MutableLiveData<Terminales>()
        viewModelScope.launch {
            val terminales = withContext(Dispatchers.IO) {
                db.terminalesDao().findOneByModel(modelo)
            }
        liveData.postValue(terminales)
        }
        return liveData
    }
}