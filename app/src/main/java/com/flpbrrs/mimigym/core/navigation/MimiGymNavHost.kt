package com.flpbrrs.mimigym.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.flpbrrs.mimigym.features.exercises.presentation.exercisesRoute
import com.flpbrrs.mimigym.features.home.presentation.homeRoute

@Composable
fun MimiGymNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.Home) {
        homeRoute(navController)
        exercisesRoute(navController)
    }
}