package com.flpbrrs.mimigym.features.home.domain.repository

import com.flpbrrs.mimigym.features.home.domain.model.WeekDaySchedule

interface HomeContentRepository {
    suspend fun getCurrentWeekSchedule(): List<WeekDaySchedule>
}