package com.piriurna.freegamestracker.ui.composables.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.piriurna.freegamestracker.ui.theme.FreeGamesTrackerTheme

@Composable
fun GTThemedPreviewColumn(
    modifier : Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content : @Composable ColumnScope.() -> Unit,
) {
    FreeGamesTrackerTheme {
        Surface(
            modifier = Modifier.background(MaterialTheme.colors.background)
        ) {
            Column(
                modifier = modifier,
                verticalArrangement = verticalArrangement,
                horizontalAlignment = horizontalAlignment,
                content = content
            )
        }
    }
}
