package com.example.kotlin.examenintegrador.data

import com.example.kotlin.examenintegrador.data.model.CasesData
import com.example.kotlin.examenintegrador.data.network.APIClient

class CasesRepository {
    private val api = APIClient()
    suspend fun getCases(country: String): CasesData?  = api.getCases(country)
}