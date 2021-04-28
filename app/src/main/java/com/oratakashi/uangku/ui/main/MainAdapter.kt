package com.oratakashi.uangku.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oratakashi.uangku.data.model.UangMasuk
import com.oratakashi.uangku.databinding.AdapterMainBinding
import com.oratakashi.viewbinding.core.ViewHolder
import com.oratakashi.viewbinding.core.viewBinding

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/
class MainAdapter : RecyclerView.Adapter<ViewHolder<AdapterMainBinding>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder<AdapterMainBinding> = viewBinding(parent)

    override fun onBindViewHolder(holder: ViewHolder<AdapterMainBinding>, position: Int) {
        with(holder.binding) {
            tvFrom.text = data[position].terimaDari
            tvJumlah.text = data[position].jumlah.toString()
            tvKeterangan.text = data[position].keterangan
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun submitData(data: List<UangMasuk>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    private val data : MutableList<UangMasuk> by lazy {
        ArrayList()
    }
}