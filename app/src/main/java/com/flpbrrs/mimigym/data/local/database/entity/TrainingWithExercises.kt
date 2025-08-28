package com.flpbrrs.mimigym.data.local.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class TrainingWithExercises(
    @Embedded val training: TrainingEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "training_id"
    )
    val exercises: List<ExerciseEntity>
)
