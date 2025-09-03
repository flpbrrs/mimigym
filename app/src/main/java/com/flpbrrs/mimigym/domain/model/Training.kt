package com.flpbrrs.mimigym.domain.model

data class Training(
    val id: Int,
    val name: String,
    val category: TrainingCategoryType,
    val exercises: List<Exercise>
)
