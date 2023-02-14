package com.piriurna.freegamestracker.ui.composables.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.piriurna.freegamestracker.ui.theme.AppTheme
import com.piriurna.freegamestracker.ui.theme.GTStyle.TextPlay
import com.piriurna.freegamestracker.ui.theme.GTStyle.TextPlay20
import com.piriurna.freegamestracker.ui.theme.GTStyle.TextPlayBold

@Composable
fun GTText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.onPrimary,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    style: TextStyle = TextPlay,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
) {

    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight,
        style = style,
        letterSpacing = letterSpacing,
        overflow = overflow,
        maxLines = maxLines
    )
}

@Preview(showBackground = false)
@Composable
private fun FGTextPreview() {
    AppTheme {

        GTText(text = "Teste 1")
        GTText(text = "Teste 2", style= TextPlayBold)
        GTText(text = "Teste 3", style = TextPlay20)
    }
}