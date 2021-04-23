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
import com.example.ttm.databinding.FragmentPotenciaBinding
import com.example.ttm.models.Producto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PotenciaFragment : Fragment() {

    private var listener: MainListener? = null
    private var binding: FragmentPotenciaBinding? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPotenciaBinding.inflate(inflater, container, false)
        val binding = binding!!
        val view = binding.root

        lifecycleScope.launch {
            val list = withContext(Dispatchers.IO) {
                App.obtenerDB().terminalesDao().findOneByPotencia()
            }
            createRecyclerView(list)
        }
        loadListView()
        return view
    }

    private fun loadListView() {

    }

    private fun createRecyclerView(list: List<Terminales>) {
        val mAdapter = RecyclerViewAdapter(list, requireContext())
        val recyclerView = binding!!.productosRecyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter //Me dió error por crear la variable adapter en lugar de solo llamarla.
        }
    }
}