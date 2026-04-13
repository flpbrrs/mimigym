package com.flpbrrs.mimigym.features.home.presentation

import com.flpbrrs.mimigym.features.home.domain.model.WeekDaySchedule

data class HomeUiState(
    val isLoading: Boolean = false,
    val weekSchedule: List<WeekDaySchedule>? = null,
    val username: String = "Usuário",
    val error: String? = null
)