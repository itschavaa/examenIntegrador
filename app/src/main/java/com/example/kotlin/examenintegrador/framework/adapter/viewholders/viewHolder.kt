package com.example.kotlin.examenintegrador.framework.adapter.viewholders

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examenintegrador.R
import com.example.kotlin.examenintegrador.data.model.CaseDetails
import com.example.kotlin.examenintegrador.databinding.ItemBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry


class viewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(covidCase: Map.Entry<String, CaseDetails>, region: String, context: Context) {
        binding.fecha.text = covidCase.key
        binding.region.text = region

        val pieChart = binding.root.findViewById<PieChart>(R.id.pieChart)
        val entries = ArrayList<PieEntry>()

        // Sumar los totales de casos para mostrar en el gráfico de pie
        var totalCases = covidCase.value.total
        var newCases = covidCase.value.new

        // Agregar los datos al conjunto de datos del gráfico de pie
        entries.add(PieEntry(newCases.toFloat(), "New Cases"))
        entries.add(PieEntry((totalCases - newCases).toFloat(), "Old Cases"))

        val dataSet = PieDataSet(entries,"")
        dataSet.colors = listOf(Color.BLUE, Color.GREEN) // Colores para las secciones del gráfico

        val data = PieData(dataSet)
        pieChart.data = data

        pieChart.description.isEnabled = true
        pieChart.description.text = covidCase.value.total.toString() + " COVID-19 cases registered until March 3, 2023"
        pieChart.invalidate() // Actualizar el gráfico


    }
}