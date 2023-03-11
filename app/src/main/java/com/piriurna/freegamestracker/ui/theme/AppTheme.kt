package com.piriurna.freegamestracker.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun AppTheme(
        colors: Colors = AppTheme.colors,
        typography: Typography = AppTheme.typography,
        shapes: RoundedCornerShapes = AppTheme.shapes,
        spacing: Spacing = AppTheme.spacing,
        content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalRoundedCornerShape provides shapes,
        LocalSpacing provides spacing
    ) {
       MaterialTheme(
           content = content
       )
    }
}
object AppTheme {

    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: RoundedCornerShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalRoundedCornerShape.current

    val spacing: Spacing
        @Composable
        @ReadOnlyComposable
        get() = LocalSpacing.current
}