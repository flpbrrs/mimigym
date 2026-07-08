package com.flpbrrs.mimigym.features.home.domain.usecase

import com.flpbrrs.mimigym.features.home.domain.model.DayStatus
import com.flpbrrs.mimigym.features.session.domain.model.WorkoutSession
import com.flpbrrs.mimigym.features.session.domain.repository.SessionRepository
import com.flpbrrs.mimigym.features.template.domain.model.DayOfWeek
import com.flpbrrs.mimigym.features.template.domain.model.WeeklySchedule
import com.flpbrrs.mimigym.features.template.domain.repository.ScheduleRepository
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class GetSessionsForCurrentWeekUseCaseTest {
    private val referenceDate: LocalDate = LocalDate.of(2026, 7, 6) // MONDAY

    @Test
    fun `Should return REST for days without template`() {
        val schedule = emptyList<WeeklySchedule>()
        val sessions = emptyList<WorkoutSession>()

        val result = executeUseCaseWith(schedule, sessions)
        val expected = expectedResult()

        Assert.assertEquals(expected, result)
    }

    @Test
    fun `Should return CURRENT for the training of day`() {
        val schedule =
            listOf(
                WeeklySchedule(
                    id = 1L,
                    templateId = 1L,
                    dayOfWeek = DayOfWeek.MON,
                ),
            )
        val sessions = emptyList<WorkoutSession>()

        val result = executeUseCaseWith(schedule, sessions)
        val expected =
            expectedResult().with(
                day = DayOfWeek.MON,
                templateId = 1,
                status = DayStatus.CURRENT,
            )

        Assert.assertEquals(expected, result)
    }

    private fun executeUseCaseWith(
        schedule: List<WeeklySchedule>,
        sessions: List<WorkoutSession>,
    ): List<GetSessionsForCurrentWeekResponse> {
        val useCase =
            GetSessionsForCurrentWeekUseCase(
                sessionRepository = FakeSessionRepository(sessions = sessions),
                scheduleRepository = FakeScheduleRepository(schedule = schedule),
            )

        return useCase(referenceDate = referenceDate)
    }

    private fun expectedResult(): List<GetSessionsForCurrentWeekResponse> =
        DayOfWeek.entries.map { day ->
            GetSessionsForCurrentWeekResponse(
                dayOfWeek = day,
                templateId = null,
                status = DayStatus.REST,
            )
        }

    private fun List<GetSessionsForCurrentWeekResponse>.with(
        day: DayOfWeek,
        templateId: Long,
        status: DayStatus,
    ): List<GetSessionsForCurrentWeekResponse> =
        this.map { sessionDay ->
            if (sessionDay.dayOfWeek == day) {
                sessionDay.copy(templateId = templateId, status = status)
            } else {
                sessionDay
            }
        }
}

private class FakeScheduleRepository(
    private val schedule: List<WeeklySchedule>,
) : ScheduleRepository {
    override fun getWeeklySchedule(): List<WeeklySchedule> = schedule
}

private class FakeSessionRepository(
    private val sessions: List<WorkoutSession>,
) : SessionRepository {
    override fun getSessionsBetween(
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<WorkoutSession> = sessions
}
