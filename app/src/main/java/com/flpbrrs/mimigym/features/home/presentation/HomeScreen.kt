package com.flpbrrs.mimigym.features.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.flpbrrs.mimigym.R
import com.flpbrrs.mimigym.core.ui.components.SectionTitle
import com.flpbrrs.mimigym.core.ui.theme.MimiGymTheme
import com.flpbrrs.mimigym.core.ui.theme.Primary
import com.flpbrrs.mimigym.features.home.presentation.components.HomeHeader
import com.flpbrrs.mimigym.features.home.presentation.components.TrainingScheduleItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel<HomeViewModel>(),
    routeActions: HomeNavigationActions,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onEvent(HomeEvent.OnInit)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(MimiGymTheme.spacing.sectionGap)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Primary,
                    shape = RoundedCornerShape(bottomEnd = MimiGymTheme.spacing.sectionGapLg)
                )
                .padding(all = MimiGymTheme.spacing.pagePadding)
                .padding(top = MimiGymTheme.spacing.sectionGapLg),
            verticalArrangement = Arrangement.spacedBy(MimiGymTheme.spacing.sectionGap)
        ) {
            HomeHeader(username = uiState.username)

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                uiState.weekSchedule?.forEach { day ->
                    TrainingScheduleItem(
                        day = day, onClick = {})
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(horizontal = MimiGymTheme.spacing.pagePadding)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Treino de hoje",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Upper B",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Button(
                onClick = { routeActions.toExercises() },
            ) {
                Text(text = "Iniciar Treino")
            }
        }

        Column(
            modifier = Modifier
                .padding(horizontal = MimiGymTheme.spacing.pagePadding)
        ) {
            SectionTitle(title = stringResource(R.string.shortcuts_menu_label))
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//private fun HomeScreenPreview() {
//    MimiGymTheme {
//        HomeScreen(
//
//        )
//    }
//}