package com.flpbrrs.mimigym.features.exercises.domain.usecase

import com.flpbrrs.mimigym.features.exercises.domain.model.Exercise
import com.flpbrrs.mimigym.features.exercises.domain.repository.ExercisesRepository

class UpdateExerciseUseCase(private val exercisesRepository: ExercisesRepository) {
    suspend operator fun invoke(exercise: Exercise): Result<Unit> {
        val existingExercise = exercisesRepository.getExerciseByNameAndMuscleGroup(
            name = exercise.name,
            muscleGroup = exercise.muscleGroup,
        )

        if (existingExercise != null && existingExercise.id != exercise.id)
            return Result.failure(Exception("Exercise already exists with current name and muscle group"))

        exercisesRepository.updateExercise(exercise)
        return Result.success(Unit)
    }
}