package com.flpbrrs.mimigym.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.flpbrrs.mimigym.data.local.database.dao.TrainingDao
import com.flpbrrs.mimigym.data.local.database.entity.ExerciseEntity
import com.flpbrrs.mimigym.data.local.database.entity.TrainingEntity

@Database(entities = [TrainingEntity::class, ExerciseEntity::class], version = 1)
abstract class MimiDatabase: RoomDatabase() {

    abstract fun trainingDAO(): TrainingDao

    companion object {
        @Volatile
        private var INSTANCE: MimiDatabase? = null

        fun getInstance(context: Context): MimiDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MimiDatabase::class.java,
                    "mimigym_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}