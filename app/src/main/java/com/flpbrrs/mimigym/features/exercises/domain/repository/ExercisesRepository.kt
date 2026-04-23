package com.flpbrrs.mimigym.features.exercises.domain.repository

import com.flpbrrs.mimigym.features.exercises.domain.model.Exercise
import com.flpbrrs.mimigym.features.exercises.domain.model.MuscleGroup
import kotlinx.coroutines.flow.Flow

interface ExercisesRepository {
    fun getExerciseList(
        name: String? = null,
        muscleGroups: MuscleGroup? = null
    ): Flow<List<Exercise>>

    fun getUsedMuscleGroups(): Flow<List<MuscleGroup>>
    suspend fun getExerciseByNameAndMuscleGroup(name: String, muscleGroup: MuscleGroup): Exercise?
    suspend fun getTemplateCountByExercise(id: Long): Int
    suspend fun registerExercise(exercise: Exercise)
    suspend fun updateExercise(exercise: Exercise)
    suspend fun deleteExercise(id: Long)
    suspend fun getExerciseById(id: Long): Exercise?
}