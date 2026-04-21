package com.flpbrrs.mimigym.features.exercises.domain.usecase

import com.flpbrrs.mimigym.features.exercises.domain.repository.ExercisesRepository

sealed interface DeleteExerciseResult {
    data object Success : DeleteExerciseResult
    data class RequiresConfirmation(val templateCount: Int) : DeleteExerciseResult
}

class DeleteExerciseUseCase(private val exercisesRepository: ExercisesRepository) {
    suspend operator fun invoke(id: Long, isConfirmed: Boolean = false): DeleteExerciseResult {
        if (!isConfirmed) {
            val templateCount = exercisesRepository.getTemplateCountByExercise(id)
            if (templateCount > 0)
                return DeleteExerciseResult.RequiresConfirmation(templateCount)
        }

        exercisesRepository.deleteExercise(id)
        return DeleteExerciseResult.Success
    }
}