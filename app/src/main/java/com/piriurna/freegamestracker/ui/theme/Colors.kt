package com.piriurna.freegamestracker.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color


val Salmon = Color(0xFFFC7786)
val Blue = Color(0xFF6A67F3)
val Green = Color(0xFF5CF64A)
val Golden = Color(0xFFD98324)

val Violet = Color(0xFF1E183D)
val Grape = Color(0xFF463F71)
val GrapeVariation = Color(0xFF302B4F)
val Black = Color(0xFF000000)
val White = Color(0xFFFBFBFB)
val Gray = Color(0xFFCCCCCC)
val Red = Color(0xFFB80C09)

val DropDownGradient = listOf(
    Black.copy(alpha = 0f),
    Black.copy(alpha = 0.15f),
    Black.copy(alpha = 0.8f)
)


data class Colors(
    var primary: Color = Salmon,
    var secondary: Color,
    var background: Color,
    var surface: Color,
    var onPrimary: Color,
    var onSecondary: Color,
    var onBackground: Color,
    var onSurface: Color,
    var error: Color,
    var onError: Color,
    var overlay: Color,
    var rating: Color,
    var status: Color
)

fun appColors(
    primary: Color,
    secondary: Color,
    background: Color,
    surface: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    error: Color,
    onError: Color,
    overlay: Color,
    rating: Color,
    status: Color
): Colors = Colors(
    primary = primary,
    secondary = secondary,
    background = background,
    surface = surface,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    onBackground = onBackground,
    onSurface = onSurface,
    error = error,
    onError = onError,
    overlay = overlay,
    rating = rating,
    status = status
)


val LocalColors = compositionLocalOf {
    appColors(
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
}