package com.piriurna.freegamestracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Salmon,
    secondary = Blue,
    background = Violet,
    surface = Grape,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
    error = Red,
    onError = White
)

private val LightColorPalette = lightColors(
    primary = Salmon,
    secondary = Blue,
    background = White,
    surface = Grape,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
    error = Red,
    onError = White
)

const val BackgroundColor = 0xFF1E183D

@Composable
fun FreeGamesTrackerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = GTType.Typography,
        shapes = GTShape.Shapes,
        content = content
    )
}