package com.flpbrrs.mimigym.features.exercises.domain.model

class Exercise(
    val id: Long,
    val name: String,
    val muscleGroup: MuscleGroup,
) {
    init {
        require(name.isNotBlank()) { "Exercise name cannot be blank" }
    }
}
