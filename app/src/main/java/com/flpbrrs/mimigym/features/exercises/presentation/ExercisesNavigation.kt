package com.flpbrrs.mimigym.features.exercises.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.flpbrrs.mimigym.core.navigation.Routes

fun NavGraphBuilder.exercisesRoute(navController: NavController) {
    composable<Routes.Exercises> {
        ExercisesScreen()
    }
}