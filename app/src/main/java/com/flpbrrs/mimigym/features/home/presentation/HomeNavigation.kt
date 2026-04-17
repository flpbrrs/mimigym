package com.flpbrrs.mimigym.features.home.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.flpbrrs.mimigym.core.navigation.Routes

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable<Routes.Home> {
        val actions = HomeNavigationActions(
            toExercises = { navController.navigate(Routes.Exercises) }
        )
        HomeScreen(routeActions = actions)
    }
}