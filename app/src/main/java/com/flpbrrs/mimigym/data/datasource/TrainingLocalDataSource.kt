package com.flpbrrs.mimigym.data.datasource

import com.flpbrrs.mimigym.data.local.database.entity.ExerciseEntity
import com.flpbrrs.mimigym.data.local.database.entity.TrainingEntity
import com.flpbrrs.mimigym.data.local.database.entity.TrainingWithExercises
import kotlinx.coroutines.flow.Flow

interface TrainingLocalDataSource {

    val userTrainings: Flow<List<TrainingEntity>>

    suspend fun saveTrainingWithExercises(training: TrainingEntity, exercises: List<ExerciseEntity>)

    suspend fun getTrainingWithExercises(trainingId: Int): TrainingWithExercises

}