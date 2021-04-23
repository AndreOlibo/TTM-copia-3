package com.example.ttm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ttm.databinding.ItemProductoListViewBinding
import com.example.ttm.models.Producto

class ListViewAdapter(context: Context, val vista: Int, val productos: List<Producto>) : ArrayAdapter<Producto>(context, vista, productos){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView

        if (view ==null) {
            view = LayoutInflater.from(context).inflate(vista, null)
        }
        val binding = ItemProductoListViewBinding.bind(view!!)

        val producto = productos[position]

        binding.itemProductoId.text = producto.id.toString()
        binding.itemProductoMarca.text = producto.marca
        binding.itemProductoModelo.text = producto.modelo
        binding.itemProductoPotencia.text = producto.potencia.toString()
        binding.itemProductoPixeles.text = producto.pixeles.toString()
        binding.itemProductoPrecio.text = producto.precio.toString()

        return view

    }
}