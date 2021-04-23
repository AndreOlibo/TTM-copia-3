package com.example.ttm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.ttm.application.App
import com.example.ttm.database.entities.Cliente
import com.example.ttm.database.entities.Compra
import com.example.ttm.databinding.ActivityDetallesBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetallesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)
        val extras = intent.extras!!
        val id = extras["id"]
        val marca = extras["marca"]
        val modelo = extras["modelo"]
        val potencia = extras["potencia"]
        val pixeles = extras["pixeles"]
        val precio = extras["precio"]

        lateinit var binding: ActivityDetallesBinding
        binding = ActivityDetallesBinding.inflate(layoutInflater)
        val view = binding.root
        val clienteModel:ClienteViewModel by viewModels()
        setContentView(view)
        binding.itemProductoId.text = id.toString()
        binding.itemProductoMarca.text = marca.toString()
        binding.itemProductoModelo.text = modelo.toString()
        binding.itemProductoPotencia.text = potencia.toString()
        binding.itemProductoPixeles.text = pixeles.toString()
        binding.itemProductoPrecio.text = precio.toString()
        binding.itemProductoPrecio.setOnClickListener {
            clienteModel.restarStock(id.toString().toInt())
        }


        clienteModel.save(Cliente(binding.usuarioNombre.text.toString(), binding.usuarioDomicilio.text.toString(), binding.usuarioEmail.text.toString()))



    }
}