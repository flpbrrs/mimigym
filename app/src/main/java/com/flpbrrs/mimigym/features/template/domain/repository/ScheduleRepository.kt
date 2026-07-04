package com.flpbrrs.mimigym.features.template.domain.repository

import com.flpbrrs.mimigym.features.template.domain.model.WeeklySchedule

interface ScheduleRepository {
    fun getWeeklySchedule(): List<WeeklySchedule>
}
