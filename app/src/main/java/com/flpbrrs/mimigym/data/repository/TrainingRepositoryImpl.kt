package com.flpbrrs.mimigym.data.repository

import com.flpbrrs.mimigym.data.datasource.TrainingLocalDataSource
import com.flpbrrs.mimigym.data.mapper.toDomain
import com.flpbrrs.mimigym.data.mapper.toEntity
import com.flpbrrs.mimigym.domain.model.Training
import com.flpbrrs.mimigym.domain.model.TrainingSummary
import com.flpbrrs.mimigym.domain.repository.TrainingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TrainingRepositoryImpl(
    private val trainingLocalDataSource: TrainingLocalDataSource
): TrainingRepository {
    override val summarizedTrainings: Flow<List<TrainingSummary>>
        get() = trainingLocalDataSource.userTrainings.map { it.toDomain() }

    override suspend fun getTrainingById(id: Int): Training {
        return trainingLocalDataSource.getTrainingWithExercises(trainingId = id).toDomain()
    }

    override suspend fun saveTraining(training: Training) {
        val trainingInfo = training.toEntity()

        trainingLocalDataSource.saveTrainingWithExercises(
            training = trainingInfo.training,
            exercises = trainingInfo.exercises
        )
    }
}