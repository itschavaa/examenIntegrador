package com.example.kotlin.examenintegrador.data

import com.example.kotlin.examenintegrador.data.model.CasesData
import com.example.kotlin.examenintegrador.data.network.APIClient

class CasesRepository(apiClient: APIClient) {
    private val api = APIClient()
    suspend fun getCases(country: String): List<CasesData>?  = api.getCases(country)
}