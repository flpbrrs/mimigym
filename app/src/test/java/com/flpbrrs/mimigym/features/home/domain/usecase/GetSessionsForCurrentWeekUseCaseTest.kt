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
    @Test
    fun `Should return REST for days without template`() {
        val schedule = emptyList<WeeklySchedule>()
        val sessions = emptyList<WorkoutSession>()

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
                    templateId = null,
                    status = DayStatus.REST,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.MON,
                    templateId = null,
                    status = DayStatus.REST,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.TUE,
                    templateId = null,
                    status = DayStatus.REST,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.WED,
                    templateId = null,
                    status = DayStatus.REST,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.THU,
                    templateId = null,
                    status = DayStatus.REST,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.FRI,
                    templateId = null,
                    status = DayStatus.REST,
                ),
                GetSessionsForCurrentWeekResponse(
                    dayOfWeek = DayOfWeek.SAT,
                    templateId = null,
                    status = DayStatus.REST,
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
