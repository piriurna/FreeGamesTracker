package com.piriurna.freegamestracker.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
        val extraSmall: Dp = 4.dp,
        val small: Dp = 8.dp,
        val mediumSmall: Dp = 12.dp,
        val medium: Dp = 16.dp,
        val mediumLarge: Dp = 20.dp,
        val large: Dp = 24.dp,
        val extraLarge: Dp = 32.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }
