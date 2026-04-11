package com.flpbrrs.mimigym.features.home.presentation

import androidx.lifecycle.ViewModel
import com.flpbrrs.mimigym.features.home.domain.model.TrainingDayInfo
import com.flpbrrs.mimigym.features.home.domain.model.WeekDaySchedule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    val weekSchedule: StateFlow<List<WeekDaySchedule>> = MutableStateFlow(
        value = listOf(
            WeekDaySchedule(
                label = "DOM",
                template = "Low. A",
                trainingInfo = TrainingDayInfo.Completed(sessionId = 1)
            ),
            WeekDaySchedule(
                label = "SEG",
                template = "Rest",
                trainingInfo = TrainingDayInfo.Rest
            ),
            WeekDaySchedule(
                label = "TER",
                template = "Upper B",
                trainingInfo = TrainingDayInfo.Completed(sessionId = 2)
            ),
            WeekDaySchedule(
                label = "QUA",
                template = "Rest",
                trainingInfo = TrainingDayInfo.Rest
            ),
            WeekDaySchedule(
                label = "QUI",
                template = "Lower B",
                trainingInfo = TrainingDayInfo.Today(templateId = 3)
            ),
            WeekDaySchedule(
                label = "SEX",
                template = "Rest",
                trainingInfo = TrainingDayInfo.Rest
            ),
            WeekDaySchedule(
                label = "SAB",
                template = "Upper A",
                trainingInfo = TrainingDayInfo.Upcoming(templateId = 4)
            )
        )
    )
}