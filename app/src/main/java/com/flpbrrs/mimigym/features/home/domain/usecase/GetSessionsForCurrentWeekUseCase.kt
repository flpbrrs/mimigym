package com.flpbrrs.mimigym.features.home.domain.usecase

import com.flpbrrs.mimigym.features.home.domain.model.DayStatus
import com.flpbrrs.mimigym.features.session.domain.repository.SessionRepository
import com.flpbrrs.mimigym.features.template.domain.model.DayOfWeek
import com.flpbrrs.mimigym.features.template.domain.repository.ScheduleRepository
import java.time.LocalDate

data class GetSessionsForCurrentWeekResponse(
    val dayOfWeek: DayOfWeek,
    val templateId: Long?,
    val status: DayStatus,
)

class GetSessionsForCurrentWeekUseCase(
    private val sessionRepository: SessionRepository,
    private val scheduleRepository: ScheduleRepository,
) {
    operator fun invoke(referenceDate: LocalDate): List<GetSessionsForCurrentWeekResponse> {
        TODO()
    }
}
