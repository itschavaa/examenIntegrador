package com.example.kotlin.examenintegrador.data.model

data class CasesData(
    val country: String,
    val region: String,
    val cases: Map<String, CaseDetails>
)
