package com.example.kotlin.examenintegrador.data.network

import com.example.kotlin.examenintegrador.data.model.CasesData
import com.example.kotlin.examenintegrador.utils.Constants
import java.lang.Exception

class APIClient {
    private val api: APIService = NetworkModuleDI()

    suspend fun getCases(country: String): List<CasesData>? {
        return try{
            api.getCases(key = Constants.KEY, country = country)
        } catch (e: Exception){
            e.printStackTrace()
            null
        }
    }
}