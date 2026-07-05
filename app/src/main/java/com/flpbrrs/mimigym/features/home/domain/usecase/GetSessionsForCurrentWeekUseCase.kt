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

private data class WeekRange(
    val startDate: LocalDate,
    val endDate: LocalDate,
)

class GetSessionsForCurrentWeekUseCase(
    private val sessionRepository: SessionRepository,
    private val scheduleRepository: ScheduleRepository,
) {
    operator fun invoke(referenceDate: LocalDate): List<GetSessionsForCurrentWeekResponse> {
        val weekRange = getWeekLimitsFor(referenceDate)

        val sessionsCompletedOfWeek =
            sessionRepository.getSessionsBetween(
                weekRange.startDate,
                weekRange.endDate,
            )
        val weekSchedule = scheduleRepository.getWeeklySchedule()

        return DayOfWeek.entries.map { day ->
            val trainingOfDay = weekSchedule.find { it.dayOfWeek == day }
            val actualDate = weekRange.startDate.plusDays(day.isoValue.toLong())

            val trainingAlreadyDone =
                sessionsCompletedOfWeek.any {
                    it.templateId == trainingOfDay?.templateId &&
                        it.startedAt.toLocalDate() == actualDate &&
                        it.finishedAt != null
                }

            GetSessionsForCurrentWeekResponse(
                dayOfWeek = day,
                templateId = trainingOfDay?.templateId,
                status =
                    when {
                        trainingOfDay == null -> DayStatus.REST
                        trainingAlreadyDone -> DayStatus.DONE
                        actualDate == referenceDate -> DayStatus.CURRENT
                        else -> DayStatus.SCHEDULED
                    },
            )
        }
    }

    private fun getWeekLimitsFor(referenceDate: LocalDate): WeekRange {
        val firstDayOfWeek = referenceDate.minusDays(((referenceDate.dayOfWeek.value % 7).toLong()))
        val lastDayOfWeek = firstDayOfWeek.plusDays(6)

        return WeekRange(firstDayOfWeek, lastDayOfWeek)
    }
}
