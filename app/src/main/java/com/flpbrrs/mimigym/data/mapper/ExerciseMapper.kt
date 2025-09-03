package com.flpbrrs.mimigym.data.mapper

import com.flpbrrs.mimigym.data.local.database.entity.ExerciseEntity
import com.flpbrrs.mimigym.domain.model.Exercise

fun ExerciseEntity.toDomain(): Exercise {
    return Exercise(
        id = this.id,
        name = this.name,
        sets = this.sets,
        reps = this.reps,
        weight = this.weight
    )
}

fun Exercise.toEntity(trainingId: Int): ExerciseEntity {
    return ExerciseEntity(
        id = this.id,
        trainingId = trainingId,
        name = this.name,
        sets = this.sets,
        reps = this.reps,
        weight = this.weight
    )
}

fun List<ExerciseEntity>.toDomain(): List<Exercise> {
    return this.map { it.toDomain() }
}

fun List<Exercise>.toEntity(trainingId: Int): List<ExerciseEntity> {
    return this.map { it.toEntity(trainingId) }
}