package com.flpbrrs.mimigym.features.session.domain.repository

import com.flpbrrs.mimigym.features.session.domain.model.WorkoutSession
import java.time.LocalDate

interface SessionRepository {
    fun getSessionsBetween(
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<WorkoutSession>
}
