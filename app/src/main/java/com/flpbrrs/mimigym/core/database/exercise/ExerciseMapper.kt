package com.flpbrrs.mimigym.core.database.exercise

import com.flpbrrs.mimigym.features.exercises.domain.model.Exercise
import com.flpbrrs.mimigym.features.exercises.domain.model.MuscleGroup

fun ExerciseEntity.toDomain() = Exercise(
    id = id,
    name = name,
    muscleGroup = MuscleGroup.valueOf(muscleGroup)
)

fun Exercise.toEntity(createdAt: Long) = ExerciseEntity(
    id = id,
    name = name,
    muscleGroup = muscleGroup.name,
    createdAt = createdAt
)