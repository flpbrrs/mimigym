package com.flpbrrs.mimigym.features.session.domain.model

import com.flpbrrs.mimigym.core.domain.model.MuscleGroup

data class SessionExercise(
    val id: Long,
    val sessionId: Long,
    val exerciseId: Long,
    val name: String,
    val muscleGroup: MuscleGroup,
    val executionOrderIndex: Int,
    val note: String?,
)
