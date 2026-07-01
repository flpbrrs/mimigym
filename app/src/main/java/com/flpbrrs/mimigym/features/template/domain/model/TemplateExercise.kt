package com.flpbrrs.mimigym.features.template.domain.model

data class TemplateExercise(
    val id: Long,
    val templateId: Long,
    val exerciseId: Long,
    val orderIndex: Int,
    val targetLoad: Double,
    val workingSetsCounts: Int,
    val targetRepRangeMin: Int,
    val targetRepRangeMax: Int,
)
