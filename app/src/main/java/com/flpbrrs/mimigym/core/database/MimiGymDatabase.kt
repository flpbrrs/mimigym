package com.flpbrrs.mimigym.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.flpbrrs.mimigym.core.database.exercise.ExerciseDao
import com.flpbrrs.mimigym.core.database.exercise.ExerciseEntity

@Database(
    entities = [ExerciseEntity::class], version = 1
)
abstract class MimiGymDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
}