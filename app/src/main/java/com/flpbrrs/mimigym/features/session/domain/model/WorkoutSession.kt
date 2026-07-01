package com.flpbrrs.mimigym.features.session.domain.model

import java.util.Date

data class WorkoutSession(
    val id: Long,
    val templateId: Long,
    val startedAt: Date,
    val finishedAt: Date?,
    val note: String?,
)
