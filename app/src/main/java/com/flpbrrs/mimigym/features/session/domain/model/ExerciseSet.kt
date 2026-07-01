package com.flpbrrs.mimigym.features.session.domain.model

data class ExerciseSet(
    val id: Long,
    val sessionExerciseId: Long,
    val setType: Int,
    val load: Double,
    val reps: Int,
    val inExerciseOrderIndex: Int,
)

// TODO: Ordem aparece em muitos locais (+3) válido a criação de um objeto de valor?
