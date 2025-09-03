package com.flpbrrs.mimigym.domain.repository

import com.flpbrrs.mimigym.domain.model.Training
import com.flpbrrs.mimigym.domain.model.TrainingSummary
import kotlinx.coroutines.flow.Flow

interface TrainingRepository {

    val summarizedTrainings: Flow<List<TrainingSummary>>

    suspend fun getTrainingById(id: Int): Training

    suspend fun saveTraining(training: Training)

}