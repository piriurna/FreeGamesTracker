package com.piriurna.freegamestracker.ui.composables.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.piriurna.freegamestracker.ui.theme.FreeGamesTrackerTheme

@Composable
fun GTThemedPreviewBox(
    modifier : Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content : @Composable BoxScope.() -> Unit,
) {
    FreeGamesTrackerTheme {
        Box(
            modifier = modifier.background(MaterialTheme.colors.background),
            contentAlignment = contentAlignment,
            propagateMinConstraints = propagateMinConstraints,
            content = content
        )
    }
}