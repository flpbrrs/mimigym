package com.flpbrrs.mimigym

import android.app.Application
import com.flpbrrs.mimigym.core.database.DataBaseModule
import com.flpbrrs.mimigym.features.exercises.di.ExercisesModule
import com.flpbrrs.mimigym.features.home.di.HomeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                DataBaseModule.data,
                HomeModule.data,
                HomeModule.domain,
                HomeModule.ui,
                ExercisesModule.data,
                ExercisesModule.domain
            )
        }
    }
}