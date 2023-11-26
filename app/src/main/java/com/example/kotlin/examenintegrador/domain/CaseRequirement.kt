package com.example.kotlin.examenintegrador.domain

import com.example.kotlin.examenintegrador.data.CasesRepository
import com.example.kotlin.examenintegrador.data.model.CasesData

class CaseRequirement(private val Repository: CasesRepository) {
    suspend operator fun invoke(country:String): List<CasesData>? {
        return Repository.getCases(country)
    }
}