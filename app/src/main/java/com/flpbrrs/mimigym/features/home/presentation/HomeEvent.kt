package com.flpbrrs.mimigym.features.home.presentation

sealed interface HomeEvent {
    data object OnInit : HomeEvent
}