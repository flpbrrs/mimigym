package com.flpbrrs.mimigym.domain.model

data class Exercise (
    val id: Int,
    val name: String,
    val sets: Int,
    val reps: Int,
    val weight: Float
)