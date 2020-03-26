package com.example.profilefakultas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fakultas_list_item.view.*

class FakAdapter(val fakItemList: List<FakData>, val clickListener: (FakData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fakultas_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(fakItemList[position], clickListener)
    }

    override fun getItemCount() = fakItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(fak: FakData, clickListener: (FakData) -> Unit) {
            itemView.namaFak.text = fak.namaFak
            itemView.fotoUPN.setImageResource(fak.fotoFak)

            itemView.setOnClickListener{clickListener(fak)}
        }
    }
}