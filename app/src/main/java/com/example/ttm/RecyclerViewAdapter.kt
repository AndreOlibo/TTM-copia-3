package com.example.ttm

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttm.database.entities.Terminales
import com.example.ttm.databinding.ItemProductoRecyclerViewBinding
import com.example.ttm.models.Producto

class RecyclerViewAdapter(val terminal:List<Terminales>, val context:Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder private constructor(val binding: ItemProductoRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun rellenarDatos(terminal: Terminales, context: Context) {
            Log.d("producto", terminal.toString())
            binding.itemProductoId.text = terminal.id.toString()
            binding.itemProductoMarca.text = terminal.marca.toString()
            binding.itemProductoModelo.text = terminal.modelo.toString()
            binding.itemProductoPotencia.text = terminal.potencia.toString()
            binding.itemProductoPixeles.text = terminal.pixeles.toString()
            binding.itemProductoPrecio.text = terminal.precio.toString()
            binding.itemProductoPrecio.setOnClickListener{

                val intent = Intent(context, DetallesActivity::class.java)
                intent.putExtra("id",terminal.id)
                intent.putExtra("marca",terminal.marca)
                intent.putExtra("modelo",terminal.modelo)
                intent.putExtra("potencia",terminal.potencia)
                intent.putExtra("pixeles",terminal.pixeles)
                intent.putExtra("precio",terminal.precio)
                context.startActivity(intent)
            }

        }

        companion object {
            fun newInstance(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProductoRecyclerViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.newInstance(parent)

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = viewHolder.rellenarDatos(terminal[position], context)

    override fun getItemCount() = terminal.size

}