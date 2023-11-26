package com.example.kotlin.examenintegrador.framework.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examenintegrador.data.CasesRepository
import com.example.kotlin.examenintegrador.data.model.CasesData
import kotlinx.coroutines.launch

class MainActivityViewModel(private val Repository: CasesRepository) : ViewModel() {
    private val _casesData = MutableLiveData<List<CasesData>>()
    val casesData: LiveData<List<CasesData>> = _casesData

    fun getCases(country: String){
        viewModelScope.launch {
            val data = Repository.getCases(country) ?: emptyList()
            _casesData.postValue(data)
        }
    }
}