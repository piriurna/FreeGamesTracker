package com.piriurna.freegamestracker.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.piriurna.freegamestracker.R

object GTStyle {
    private val PlayFont = FontFamily(
        Font(R.font.play_regular),
        Font(R.font.play_bold, FontWeight.Bold),
    )

    val TextPlay = TextStyle(
        fontFamily = PlayFont,
        fontSize = 16.sp,
    )
    val TextPlayBold = TextPlay.copy(
        fontWeight = FontWeight.Bold
    )

    val TextPlay20 = TextPlay.copy(
        fontSize = 20.sp,
        lineHeight = 4.sp
    )
}