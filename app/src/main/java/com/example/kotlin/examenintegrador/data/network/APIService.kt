package com.example.kotlin.examenintegrador.data.network

import com.example.kotlin.examenintegrador.data.model.CasesData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * A p i service
 *
 * @constructor Create empty A p i service
 */
interface APIService {
    /**
     * Get cases from the specific country
     *
     * @param key: api key
     * @param country: country of the data
     * @return List of [CasesData]
     */
    @GET("covid19")
    suspend fun getCases(
        @Header("X-Api-Key") key: String,
        @Query("country") country: String
    ): List<CasesData>
}