package com.flpbrrs.mimigym.features.session.domain.model

import java.time.LocalDateTime

data class WorkoutSession(
    val id: Long,
    val templateId: Long,
    val startedAt: LocalDateTime,
    val finishedAt: LocalDateTime?,
    val note: String?,
)
