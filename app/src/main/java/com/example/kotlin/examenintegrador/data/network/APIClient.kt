package com.example.kotlin.examenintegrador.data.network

import com.example.kotlin.examenintegrador.data.model.CasesData
import com.example.kotlin.examenintegrador.utils.Constants
import java.lang.Exception

/**
 * A p i client
 *
 * @constructor Create empty A p i client
 */
class APIClient {
    private val api: APIService = NetworkModuleDI()

    /**
     * Get cases from the specific country
     *
     * @param country
     * @return List of [CasesData]
     */
    suspend fun getCases(country: String): List<CasesData>? {
        return try{
            api.getCases(key = Constants.KEY, country = country)
        } catch (e: Exception){
            e.printStackTrace()
            null
        }
    }
}