package com.flpbrrs.mimigym.features.exercises.di

import com.flpbrrs.mimigym.features.exercises.data.ExerciseRepositoryImpl
import com.flpbrrs.mimigym.features.exercises.domain.repository.ExercisesRepository
import com.flpbrrs.mimigym.features.exercises.domain.usecase.DeleteExerciseUseCase
import com.flpbrrs.mimigym.features.exercises.domain.usecase.RegisterExerciseUseCase
import com.flpbrrs.mimigym.features.exercises.domain.usecase.UpdateExerciseUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object ExercisesModule {
    val data = module {
        singleOf(::ExerciseRepositoryImpl) {
            bind<ExercisesRepository>()
        }
    }

    val domain = module {
        factoryOf(::RegisterExerciseUseCase)
        factoryOf(::UpdateExerciseUseCase)
        factoryOf(::DeleteExerciseUseCase)
    }
}