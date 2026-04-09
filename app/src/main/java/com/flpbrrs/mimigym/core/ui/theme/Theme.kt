package com.flpbrrs.mimigym.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    primaryContainer = PrimaryContainer,
    onPrimary = OnPrimary,
    onPrimaryContainer = OnPrimaryContainer,
    secondary = Secondary,
    onSecondary = OnSecondary,
    secondaryContainer = SecondaryContainer,
    onSecondaryContainer = OnSecondaryContainer,
    tertiary = Tertiary,
    onTertiary = OnTertiary,
    tertiaryContainer = TertiaryContainer,
    onTertiaryContainer = OnTertiaryContainer,
    surface = Surface,
    onSurface = OnSurface,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = OnSurfaceVariant,
    background = Background,
    onBackground = OnBackground,
    inverseSurface = InverseSurface,
    inverseOnSurface = InverseOnSurface,
    outline = Outline,
    outlineVariant = OutlineVariant,
)

@Composable
fun MimiGymTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        localSpacing provides Spacing(),
        localRadius provides Radius(),
        localSizes provides Sizes()
    ) {
        MaterialTheme(
            colorScheme = LightColorScheme,
            typography = Typography,
            content = content
        )
    }
}

object MimiGymTheme {
    val spacing: Spacing
        @Composable
        get() = localSpacing.current

    val radius: Radius
        @Composable
        get() = localRadius.current

    val sizes: Sizes
        @Composable
        get() = localSizes.current
}