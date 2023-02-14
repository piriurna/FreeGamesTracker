package com.piriurna.freegamestracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

private val darkColorPalette = appColors(
    primary = Salmon,
    secondary = Blue,
    background = Violet,
    surface = Grape,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
    error = Red,
    onError = White,
    overlay = GrapeVariation,
    rating = Golden,
    status = Green
)

private val lightColorPalette = appColors(
    primary = Salmon,
    secondary = Blue,
    background = Violet,
    surface = Grape,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
    error = Red,
    onError = White,
    overlay = GrapeVariation,
    rating = Golden,
    status = Green
)

@Composable
fun FreeGamesTrackerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    AppTheme(
        colors = colors,
        typography = GTType.Typography,
        shapes = RoundedCornerShapes(),
        content = content
    )
}