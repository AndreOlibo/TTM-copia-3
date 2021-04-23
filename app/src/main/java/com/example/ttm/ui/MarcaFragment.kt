package com.example.ttm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ttm.*
import com.example.ttm.application.App
import com.example.ttm.database.entities.Terminales
import com.example.ttm.databinding.FragmentMarcaBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MarcaFragment : Fragment() {

    private var listener: MainListener? = null
    private var binding: FragmentMarcaBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarcaBinding.inflate(inflater, container, false)
        val binding = binding!!
        val view = binding.root

        lifecycleScope.launch{
            val list = withContext(Dispatchers.IO) {
                App.obtenerDB().terminalesDao().findAllByMarca()
            }
            createRecyclerView(list)
        }
        loadListView()
        return view
    }

    private fun loadListView(){

    }

    private fun createRecyclerView(list: List<Terminales>) {
        val mAdapter = RecyclerViewAdapter(list, requireContext())
        val recyclerView = binding!!.productosRecyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter //Me dió error por crear la variable adapter en lugar de solo llamarla.
        }
    }

    /*private fun createListview(){
        val adapter = ArrayAdapter<Producto>(
               requireContext(),
               android.R.layout.simple_list_item_1,
               cargarProductos()
       )

        val adapter = ListViewAdapter(requireContext(), R.layout.item_producto_list_view, cargarProductos())
        //binding!!.productosListView.adapter = adapter
    }*/

   /*private fun cargarProductos(): List<Producto> {
        val productos = mutableListOf<Producto>()

        productos.add(Producto(1, "Apple", "Iphone 12 mini", "Potencia: 9.3", "Píxeles: 12", 809.00))
        productos.add(Producto(2, "Apple", "Iphone 12", "Potencia: 9.4", "Píxeles: 12", 909.00))
        productos.add(Producto(3, "Apple", "Iphone 12 Pro", "Potencia: 9.9", "Píxeles: 12", 1159.00))
        productos.add(Producto(4, "Apple", "Iphone 12 Pro Max", "Potencia: 10.00", "Píxeles: 12", 1259.00))
        productos.add(Producto(5, "Samsung", "Galaxy A72", "Potencia: 7.4", "Píxeles: 64", 449.00))
        productos.add(Producto(6, "Samsung", "Galaxy S21", "Potencia: 9.0", "Píxeles: 64", 1159.00))
        productos.add(Producto(7, "Samsung", "Galaxy Note", "Potencia: 8.7", "Píxeles: 108", 779.00))
        productos.add(Producto(8, "Samsung", "Galaxy Z Fold 2", "Potencia: 9.5", "Píxeles: 12", 1699.00))
        productos.add(Producto(9, "Xiaomi", "Mi 10T Lite", "Potencia: 7.2", "Píxeles: 64", 249.00))
        productos.add(Producto(10, "Xiaomi", "Mi 10T Pro", "Potencia: 8.0", "Píxeles: 108", 499.00))
        productos.add(Producto(11, "Xiaomi", "Mi 11 Lite", "Potencia: 7.8", "Píxeles: 64", 349.99))
        productos.add(Producto(12, "Xiaomi", "Mi 11 ", "Potencia: 8.2", "Píxeles: 108", 749.99))




        return productos
    }*/

    /*override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity
        listener!!.showBottomNavigation()
    }*/
}