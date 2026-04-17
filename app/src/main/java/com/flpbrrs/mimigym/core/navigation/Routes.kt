package com.flpbrrs.mimigym.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes {
    @Serializable
    data object Home : Routes

    @Serializable
    data object Exercises : Routes
    @Serializable
    data class Execution(val sessionId: Long) : Routes
}