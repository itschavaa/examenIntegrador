package com.example.kotlin.examenintegrador.framework.view.activities

import android.app.Activity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examenintegrador.data.CasesRepository
import com.example.kotlin.examenintegrador.data.network.APIClient
import com.example.kotlin.examenintegrador.databinding.ActivityMainBinding
import com.example.kotlin.examenintegrador.framework.adapter.Adapter
import com.example.kotlin.examenintegrador.framework.viewmodel.MainActivityViewModel
import com.example.kotlin.examenintegrador.framework.viewmodel.viewModelFactory

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repository = CasesRepository(APIClient())
    private val viewModel: MainActivityViewModel by viewModels { viewModelFactory(repository) }
    private val adapter: Adapter by lazy { Adapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        initializeObservers()
        viewModel.getCases("canada")
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }
    private fun initializeObservers() {
        viewModel.casesData.observe(this) { apiObjects ->
            apiObjects?.let {
                adapter.setData(it)
            }
        }
    }

}