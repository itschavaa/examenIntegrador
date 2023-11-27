package com.example.kotlin.examenintegrador.framework.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examenintegrador.data.model.CasesData
import com.example.kotlin.examenintegrador.databinding.ItemBinding
import com.example.kotlin.examenintegrador.framework.adapter.viewholders.viewHolder

/**
 * Adapter
 *
 * @property context: layout that is going to be manage
 * @constructor Create empty Adapter
 */
class Adapter(private val context: Context) : RecyclerView.Adapter<viewHolder>() {
    private var data: List<CasesData> = listOf()

    /**
     * Set List<[CasesData]> in order to display them
     *
     * @param newData
     */
    fun setData(newData: List<CasesData>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = data[position]

        val lastEntry = data.cases.entries.lastOrNull()
        lastEntry?.let {
            holder.bind(it, data.region, context)
        }
    }
    override fun getItemCount(): Int {
        return data.size
    }
}