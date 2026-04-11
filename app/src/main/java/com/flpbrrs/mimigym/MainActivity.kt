package com.flpbrrs.mimigym

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.flpbrrs.mimigym.core.ui.theme.MimiGymTheme
import com.flpbrrs.mimigym.core.ui.theme.Primary
import com.flpbrrs.mimigym.features.home.presentation.HomeViewModel
import com.flpbrrs.mimigym.features.home.presentation.components.HomeHeader
import com.flpbrrs.mimigym.features.home.presentation.components.TrainingScheduleItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MimiGymTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = innerPadding.calculateBottomPadding()),
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val trainingSchedule by HomeViewModel().weekSchedule.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Primary,
                shape = RoundedCornerShape(bottomEnd = MimiGymTheme.spacing.sectionGapLg)
            )
            .padding(all = MimiGymTheme.spacing.pagePadding)
            .padding(top = MimiGymTheme.spacing.sectionGapLg),
        verticalArrangement = Arrangement.spacedBy(MimiGymTheme.spacing.sectionGap)
    ) {
        HomeHeader(username = "Felipe")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            trainingSchedule.forEach { day ->
                TrainingScheduleItem(
                    day = day,
                    onClick = {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MimiGymTheme {
        Greeting()
    }
}