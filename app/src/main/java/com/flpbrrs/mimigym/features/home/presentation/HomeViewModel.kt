package com.flpbrrs.mimigym.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flpbrrs.mimigym.features.home.domain.usecase.GetHomeContentUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomeContentUseCase: GetHomeContentUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(value = HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnInit -> getHomeContent()
        }
    }

    private fun getHomeContent() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            try {
                val weekSchedule = getHomeContentUseCase()
                _uiState.update {
                    it.copy(isLoading = false, weekSchedule = weekSchedule, username = "Felipão")
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}