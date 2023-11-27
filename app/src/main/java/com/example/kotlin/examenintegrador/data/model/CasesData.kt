package com.example.kotlin.examenintegrador.data.model

/**
 * Cases data
 *
 * @property country: info country
 * @property region: region of the country
 * @property cases: set of cases
 * @constructor Create empty Cases data
 */
data class CasesData(
    val country: String,
    val region: String,
    val cases: Map<String, CaseDetails>
)
