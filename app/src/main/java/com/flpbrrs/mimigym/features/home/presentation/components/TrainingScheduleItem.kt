package com.flpbrrs.mimigym.features.home.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.flpbrrs.mimigym.R
import com.flpbrrs.mimigym.core.ui.theme.MimiGymTheme
import com.flpbrrs.mimigym.features.home.domain.model.TrainingDayInfo
import com.flpbrrs.mimigym.features.home.domain.model.WeekDaySchedule

private data class ComponentStyle(
    val textColor: Color, val border: BorderStroke, val contentColor: Color
)

@Composable
fun TrainingScheduleItem(
    modifier: Modifier = Modifier,
    day: WeekDaySchedule,
    onClick: (TrainingDayInfo) -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MimiGymTheme.spacing.sm),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val style = when (day.trainingInfo) {
            is TrainingDayInfo.Completed -> ComponentStyle(
                textColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.tertiary,
                border = BorderStroke(
                    width = 0.dp, color = MaterialTheme.colorScheme.tertiary
                ),
            )

            TrainingDayInfo.Rest -> ComponentStyle(
                textColor = MaterialTheme.colorScheme.inverseSurface,
                contentColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.08f),
                border = BorderStroke(
                    width = 0.dp, color = MaterialTheme.colorScheme.surface.copy(alpha = 0.08f)
                ),
            )

            is TrainingDayInfo.Today -> ComponentStyle(
                textColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.tertiaryContainer,
                border = BorderStroke(
                    width = MimiGymTheme.spacing.xxs,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                ),
            )

            is TrainingDayInfo.Upcoming -> ComponentStyle(
                textColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.8f),
                contentColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.4f),
                border = BorderStroke(
                    width = 0.dp,
                    color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.4f)
                ),
            )
        }

        Text(
            text = day.label.uppercase(),
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
            color = style.textColor
        )

        OutlinedIconButton(
            modifier = Modifier,
            border = style.border,
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = style.contentColor,
            ),
            onClick = { onClick(day.trainingInfo) },
        ) {
            when (day.trainingInfo) {
                is TrainingDayInfo.Completed -> {
                    Icon(
                        painter = painterResource(R.drawable.ic_check_small),
                        contentDescription = stringResource(R.string.training_done),
                        tint = MaterialTheme.colorScheme.surface
                    )
                }

                TrainingDayInfo.Rest -> {
                    Icon(
                        painter = painterResource(R.drawable.ic_check_indeterminate),
                        contentDescription = stringResource(R.string.training_rest),
                        tint = MaterialTheme.colorScheme.inverseSurface
                    )
                }

                is TrainingDayInfo.Today -> {
                    Icon(
                        painter = painterResource(R.drawable.ic_exercise_filled),
                        contentDescription = stringResource(R.string.training_today),
                        tint = MaterialTheme.colorScheme.inverseSurface
                    )
                }

                is TrainingDayInfo.Upcoming -> {
                    Icon(
                        painter = painterResource(R.drawable.ic_exercise),
                        contentDescription = stringResource(R.string.training_upcoming),
                        tint = MaterialTheme.colorScheme.surface
                    )
                }
            }

        }
        Text(
            text = day.template,
            style = MaterialTheme.typography.labelSmall,
            color = style.textColor
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1B4332)
@Composable
private fun TrainingScheduleItemPreview() {
    MimiGymTheme {
        TrainingScheduleItem(
            day = WeekDaySchedule(
                label = "DOM",
                template = "Low. A",
                trainingInfo = TrainingDayInfo.Completed(sessionId = 1)
            )
        )
    }
}