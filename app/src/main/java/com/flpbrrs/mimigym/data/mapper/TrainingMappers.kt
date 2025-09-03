package com.flpbrrs.mimigym.data.mapper

import com.flpbrrs.mimigym.data.local.database.entity.TrainingEntity
import com.flpbrrs.mimigym.data.local.database.entity.TrainingWithExercises
import com.flpbrrs.mimigym.domain.model.Training
import com.flpbrrs.mimigym.domain.model.TrainingCategoryType

fun TrainingWithExercises.toDomain(): Training {
    return Training(
        id = this.training.id,
        name = this.training.name,
        category = TrainingCategoryType.valueOf(this.training.category),
        exercises = this.exercises.toDomain()
    )
}

fun Training.toEntity(): TrainingWithExercises {
    return TrainingWithExercises(
        training = TrainingEntity(
            id = this.id,
            name = this.name,
            category = this.category.name
        ),
        exercises = this.exercises.toEntity(trainingId = this.id)
    )
}