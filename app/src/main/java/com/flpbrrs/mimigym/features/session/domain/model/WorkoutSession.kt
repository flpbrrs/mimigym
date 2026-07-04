package com.flpbrrs.mimigym.features.session.domain.model

import java.time.LocalDate

data class WorkoutSession(
    val id: Long,
    val templateId: Long,
    val startedAt: LocalDate,
    val finishedAt: LocalDate?,
    val note: String?,
)
