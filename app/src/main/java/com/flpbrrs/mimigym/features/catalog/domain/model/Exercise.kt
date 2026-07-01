package com.flpbrrs.mimigym.features.catalog.domain.model

import com.flpbrrs.mimigym.core.domain.model.MuscleGroup

data class Exercise(
    val id: Long,
    val name: String,
    val muscleGroup: MuscleGroup,
)
