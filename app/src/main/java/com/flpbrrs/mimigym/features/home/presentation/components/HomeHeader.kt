package com.flpbrrs.mimigym.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.flpbrrs.mimigym.R
import com.flpbrrs.mimigym.core.ui.theme.MimiGymTheme
import com.flpbrrs.mimigym.core.ui.theme.OnPrimary
import com.flpbrrs.mimigym.core.ui.theme.OnSecondary
import com.flpbrrs.mimigym.core.ui.theme.Secondary
import com.flpbrrs.mimigym.core.ui.theme.SecondaryContainer
import com.flpbrrs.mimigym.core.ui.theme.Typography

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    username: String = stringResource(R.string.default_username),
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(MimiGymTheme.spacing.xl),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(color = Secondary, shape = CircleShape)
                .size(MimiGymTheme.sizes.avatar), contentAlignment = Alignment.Center
        ) {
            Text(
                text = username.uppercase().slice(IntRange(start = 0, 0)),
                style = Typography.headlineSmall,
                color = OnSecondary
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(R.string.welcome_message),
                style = Typography.labelLarge,
                color = SecondaryContainer
            )
            Text(
                text = username, style = Typography.displaySmall, color = OnPrimary
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1B4332)
@Composable
private fun HomeHeaderPreview() {
    HomeHeader()
}