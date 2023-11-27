package com.example.kotlin.examenintegrador.data

import com.example.kotlin.examenintegrador.data.model.CasesData
import com.example.kotlin.examenintegrador.data.network.APIClient

/**
 * Repository that manage the use of the API
 *
 * @constructor
 *
 * @param apiClient
 */
class CasesRepository(apiClient: APIClient) {
    private val api = APIClient()

    /**
     * Get cases from the specific country
     *
     * @param country
     * @return List of [CasesData]
     */
    suspend fun getCases(country: String): List<CasesData>?  = api.getCases(country)
}