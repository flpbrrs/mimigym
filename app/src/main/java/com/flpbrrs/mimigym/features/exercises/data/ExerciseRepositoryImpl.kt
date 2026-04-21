package com.flpbrrs.mimigym.features.exercises.data

import com.flpbrrs.mimigym.core.database.exercise.ExerciseDao
import com.flpbrrs.mimigym.core.database.exercise.toDomain
import com.flpbrrs.mimigym.core.database.exercise.toEntity
import com.flpbrrs.mimigym.features.exercises.domain.model.Exercise
import com.flpbrrs.mimigym.features.exercises.domain.model.MuscleGroup
import com.flpbrrs.mimigym.features.exercises.domain.repository.ExercisesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ExerciseRepositoryImpl(
    private val exerciseDao: ExerciseDao
) : ExercisesRepository {
    override fun getExerciseList(
        name: String?, muscleGroups: MuscleGroup?
    ): Flow<List<Exercise>> = exerciseDao.getFilteredList(
        name = name, muscleGroup = muscleGroups?.name
    ).map { exercises -> exercises.map { it.toDomain() } }

    override fun getUsedMuscleGroups(): Flow<List<MuscleGroup>> = exerciseDao.getUsedMuscleGroups()
        .map { muscleGroup -> muscleGroup.map { MuscleGroup.valueOf(it) } }

    override suspend fun getExerciseByNameAndMuscleGroup(
        name: String,
        muscleGroup: MuscleGroup,
    ): Exercise? =
        exerciseDao.getByNameAndMuscleGroup(name = name, muscleGroup = muscleGroup.name)?.toDomain()

    override suspend fun getTemplateCountByExercise(id: Long): Int =
        exerciseDao.getTemplateCountByExercise(id)

    override suspend fun registerExercise(exercise: Exercise) =
        exerciseDao.insert(exercise.toEntity(createdAt = System.currentTimeMillis()))

    override suspend fun updateExercise(exercise: Exercise) {
        val createdAt = exerciseDao.getById(exercise.id)?.createdAt ?: System.currentTimeMillis()
        exerciseDao.update(exercise.toEntity(createdAt = createdAt))
    }

    override suspend fun deleteExercise(id: Long) = exerciseDao.deleteById(id)

    override suspend fun getExerciseById(id: Long): Exercise? = exerciseDao.getById(id)?.toDomain()
}