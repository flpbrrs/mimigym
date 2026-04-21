package com.flpbrrs.mimigym.features.exercises.di

import com.flpbrrs.mimigym.features.exercises.data.ExerciseRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object ExercisesModule {
    val data = module {
        singleOf(::ExerciseRepositoryImpl) {
            bind<ExerciseRepositoryImpl>()
        }
    }
}