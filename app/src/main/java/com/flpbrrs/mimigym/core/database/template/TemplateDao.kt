package com.flpbrrs.mimigym.core.database.template

import androidx.room.Dao
import androidx.room.Query

@Dao
interface TemplateDao {
    @Query(value = "select * from weekly_schedule order by day_of_week asc")
    suspend fun getWeeklySchedule(): List<WeeklyScheduleEntity>

    @Query(value = "select * from template_workout")
    suspend fun getAllTemplateWorkouts(): List<TemplateWorkoutEntity>
}