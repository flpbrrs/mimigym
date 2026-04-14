package com.flpbrrs.mimigym.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.flpbrrs.mimigym.core.database.exercise.ExerciseDao
import com.flpbrrs.mimigym.core.database.exercise.ExerciseEntity
import com.flpbrrs.mimigym.core.database.session.ExerciseSetEntity
import com.flpbrrs.mimigym.core.database.session.SessionDao
import com.flpbrrs.mimigym.core.database.session.SessionExerciseEntity
import com.flpbrrs.mimigym.core.database.session.SessionWorkoutEntity
import com.flpbrrs.mimigym.core.database.template.TemplateDao
import com.flpbrrs.mimigym.core.database.template.TemplateExerciseEntity
import com.flpbrrs.mimigym.core.database.template.TemplateWorkoutEntity
import com.flpbrrs.mimigym.core.database.template.WeeklyScheduleEntity

@Database(
    entities = [
        ExerciseEntity::class,
        TemplateExerciseEntity::class,
        TemplateWorkoutEntity::class,
        WeeklyScheduleEntity::class,
        ExerciseSetEntity::class,
        SessionExerciseEntity::class,
        SessionWorkoutEntity::class
    ],
    version = 1
)
abstract class MimiGymDatabase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
    abstract fun templateDao(): TemplateDao
    abstract fun sessionDao(): SessionDao
}