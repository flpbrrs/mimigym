package com.flpbrrs.mimigym.features.exercises.domain.usecase

import com.flpbrrs.mimigym.features.exercises.domain.model.Exercise
import com.flpbrrs.mimigym.features.exercises.domain.repository.ExercisesRepository

class RegisterExerciseUseCase(private val exercisesRepository: ExercisesRepository) {
    suspend operator fun invoke(exercise: Exercise): Result<Unit> {
        val existingExercise = exercisesRepository.getExerciseByNameAndMuscleGroup(
            name = exercise.name,
            muscleGroup = exercise.muscleGroup
        )

        if (existingExercise != null)
            return Result.failure(Exception("Exercise already exists"))

        exercisesRepository.registerExercise(exercise)
        return Result.success(Unit)
    }
}