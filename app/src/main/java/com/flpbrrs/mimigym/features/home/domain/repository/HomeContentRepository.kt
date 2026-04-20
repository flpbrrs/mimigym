package com.flpbrrs.mimigym.features.home.domain.repository

import com.flpbrrs.mimigym.core.database.template.TemplateWorkoutEntity
import com.flpbrrs.mimigym.core.database.template.WeeklyScheduleEntity

interface HomeContentRepository {
    suspend fun getCurrentWeekSchedule(): List<WeeklyScheduleEntity>
    suspend fun getAllTemplateWorkouts(): List<TemplateWorkoutEntity>
}