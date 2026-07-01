package com.flpbrrs.mimigym.features.template.domain.model

data class WeeklySchedule(
    val id: Long,
    val templateId: Long,
    val dayOfWeek: DayOfWeek,
)
