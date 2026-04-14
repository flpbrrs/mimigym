package com.flpbrrs.mimigym.core.database

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DataBaseModule {
    val data = module {
        single {
            Room.databaseBuilder(
                context = androidContext(),
                klass = MimiGymDatabase::class.java,
                name = "mimi_gym_db"
            ).build()
        }

        single { get<MimiGymDatabase>().exerciseDao() }
    }
}