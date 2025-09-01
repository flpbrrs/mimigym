package com.flpbrrs.mimigym.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.flpbrrs.mimigym.data.local.database.entity.ExerciseEntity
import com.flpbrrs.mimigym.data.local.database.entity.TrainingEntity
import com.flpbrrs.mimigym.data.local.database.entity.TrainingWithExercises
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingDao {

    @Query("SELECT * FROM trainings")
    fun getAllSummarizedTrainings(): Flow<List<TrainingEntity>>

    @Transaction
    @Query("SELECT * FROM trainings where id = :id")
    suspend fun getTrainingById(id: Int): TrainingWithExercises

    @Transaction
    suspend fun saveTrainingWithExercises(training: TrainingEntity, exercises: List<ExerciseEntity>) {
        val trainingId = insertTraining(training)

        insertAllExercises(
            *exercises.map { exercise ->
                exercise.copy(trainingId = trainingId.toInt())
            }.toTypedArray()
        )
    }

    @Insert
    suspend fun insertTraining(training: TrainingEntity): Long

    @Insert
    suspend fun insertAllExercises(vararg exercise: ExerciseEntity)

}