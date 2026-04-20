package com.flpbrrs.mimigym.features.home.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.flpbrrs.mimigym.features.home.domain.model.TrainingDayInfo
import com.flpbrrs.mimigym.features.home.domain.model.WeekDaySchedule
import com.flpbrrs.mimigym.features.home.domain.repository.HomeContentRepository
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

class GetHomeContentUseCase(
    private val homeContentRepository: HomeContentRepository
) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(): List<WeekDaySchedule> {
        val today = LocalDate.now()
        val monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))

        val weekSchedule = homeContentRepository.getCurrentWeekSchedule()
        val templates = homeContentRepository.getAllTemplateWorkouts()

        // TODO: Falta só associar as sessions relizadas ou não

        return (1..7).map { offset ->
            val dayDate = monday.plusDays(offset.toLong())

            val template = weekSchedule.find { it.dayOfWeek == offset }
            val templateInfo = templates.find { it.id == template?.templateId }

            val trainingInfo = when {
                template == null ->
                    TrainingDayInfo.Rest

                dayDate.isEqual(today) ->
                    TrainingDayInfo.Today(templateId = template.templateId)

                else ->
                    TrainingDayInfo.Upcoming(templateId = template.templateId)
            }

            WeekDaySchedule(
                label = convertDayOfWeekLabel(offset),
                template = templateInfo?.name ?: "Rest",
                trainingInfo = trainingInfo
            )
        }
    }

    private fun convertDayOfWeekLabel(dayOfWeek: Int) = when (dayOfWeek) {
        1 -> "DOM"
        2 -> "SEG"
        3 -> "TER"
        4 -> "QUA"
        5 -> "QUI"
        6 -> "SEX"
        7 -> "SAB"
        else -> ""
    }
}