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
        val (firstDayOfWeek, lastDayOfWeek) = getWeekLimitsFor(referenceDate)

        val sessionsCompletedOfWeek =
            sessionRepository.getSessionsBetween(
                firstDayOfWeek,
                lastDayOfWeek,
            )
        val weekSchedule = scheduleRepository.getWeeklySchedule()

        return DayOfWeek.entries.mapIndexed { index, day ->
            val trainingOfDay = weekSchedule.find { it.dayOfWeek == day }
            val actualDate = firstDayOfWeek.plusDays(index.toLong())

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

    private fun getWeekLimitsFor(referenceDate: LocalDate): Pair<LocalDate, LocalDate> {
        val firstDayOfWeek = referenceDate.minusDays(((referenceDate.dayOfWeek.value % 7).toLong()))
        val lastDayOfWeek = firstDayOfWeek.plusDays(6)

        return Pair(firstDayOfWeek, lastDayOfWeek)
    }
}
