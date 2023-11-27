package com.example.kotlin.examenintegrador.data.model

/**
 * Case details
 *
 * @property total: total covid cases
 * @property new: new covid cases
 * @constructor Create empty Case details
 */
data class CaseDetails(
    val total: Int,
    val new: Int
)
