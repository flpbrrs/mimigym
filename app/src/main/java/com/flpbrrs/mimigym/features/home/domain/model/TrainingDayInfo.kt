package com.flpbrrs.mimigym.features.home.domain.model

sealed interface TrainingDayInfo {
    data object Completed : TrainingDayInfo
    data object Today     : TrainingDayInfo
    data object Rest      : TrainingDayInfo
    data object Upcoming  : TrainingDayInfo
}