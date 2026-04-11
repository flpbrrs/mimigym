package com.flpbrrs.mimigym.features.home.domain.model

sealed interface TrainingDayInfo {
    data class Completed(val sessionId: Long) : TrainingDayInfo
    data class Today(val templateId: Long) : TrainingDayInfo
    data object Rest : TrainingDayInfo
    data class Upcoming(val templateId: Long) : TrainingDayInfo
}