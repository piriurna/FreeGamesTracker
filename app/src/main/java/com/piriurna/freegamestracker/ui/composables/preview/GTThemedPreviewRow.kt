package com.piriurna.freegamestracker.ui.composables.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.piriurna.freegamestracker.ui.theme.FreeGamesTrackerTheme

@Composable
fun GTThemedPreviewRow(
    modifier : Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content : @Composable RowScope.() -> Unit,
) {
    FreeGamesTrackerTheme {
        Row(
            modifier = modifier.background(MaterialTheme.colors.background),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment,
            content = content
        )
    }
}