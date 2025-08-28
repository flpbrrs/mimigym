package com.flpbrrs.mimigym.data.datasource

import com.flpbrrs.mimigym.data.local.database.dao.TrainingDao
import com.flpbrrs.mimigym.data.local.database.entity.ExerciseEntity
import com.flpbrrs.mimigym.data.local.database.entity.TrainingEntity
import com.flpbrrs.mimigym.data.local.database.entity.TrainingWithExercises
import kotlinx.coroutines.flow.Flow

class TrainingLocalDataSourceImpl(
    private val trainingDao: TrainingDao
): TrainingLocalDataSource {
    override val userTrainings: Flow<List<TrainingEntity>>
        get() = trainingDao.getAllSummarizedTrainings()

    override suspend fun saveTrainingWithExercises(
        training: TrainingEntity,
        exercises: List<ExerciseEntity>
    ) = trainingDao.saveTrainingWithExercises(training = training, exercises = exercises)

    override suspend fun getTrainingWithExercises(trainingId: Int): TrainingWithExercises =
        trainingDao.getTrainingById(trainingId)
}