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
import java.time.LocalDateTime

class GetSessionsForCurrentWeekUseCaseTest {
    @Test
    fun `Should return REST for a day without template`() {
        val schedule =
            listOf(
                WeeklySchedule(id = 1, templateId = 1, dayOfWeek = DayOfWeek.SUN),
                WeeklySchedule(id = 2, templateId = 2, dayOfWeek = DayOfWeek.TUE),
                WeeklySchedule(id = 3, templateId = 3, dayOfWeek = DayOfWeek.THU),
                WeeklySchedule(id = 4, templateId = 4, dayOfWeek = DayOfWeek.SAT),
            )
        val sessions =
            listOf(
                WorkoutSession(
                    id = 1,
                    templateId = 1,
                    startedAt = LocalDateTime.of(2026, 7, 5, 9, 0),
                    finishedAt = LocalDateTime.of(2026, 7, 5, 10, 0),
                    note = null,
                ),
            )
        val useCase =
            GetSessionsForCurrentWeekUseCase(
                sessionRepository = FakeSessionRepository(sessions = sessions),
                scheduleRepository = FakeScheduleRepository(schedule = schedule),
            )

        val referenceDate = LocalDate.of(2026, 7, 6) // MONDAY
        val result = useCase(referenceDate = referenceDate)

        val expected =
            listOf(
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.SUN,
                    templateId = 1,
                    status = DayStatus.DONE,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.MON,
                    templateId = null,
                    status = DayStatus.REST,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.TUE,
                    templateId = 2,
                    status = DayStatus.SCHEDULED,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.WED,
                    templateId = null,
                    status = DayStatus.REST,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.THU,
                    templateId = 3,
                    status = DayStatus.SCHEDULED,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.FRI,
                    templateId = null,
                    status = DayStatus.REST,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.SAT,
                    templateId = 4,
                    status = DayStatus.SCHEDULED,
                ),
            )
        Assert.assertEquals(expected, result)
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
