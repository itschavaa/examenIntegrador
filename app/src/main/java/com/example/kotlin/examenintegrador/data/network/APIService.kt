package com.example.kotlin.examenintegrador.data.network

import com.example.kotlin.examenintegrador.data.model.CasesData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface APIService {
    @GET("covid19")
    suspend fun getCases(
        @Header("X-Api-Key") key: String,
        @Query("country") country: String
    ): List<CasesData>
}