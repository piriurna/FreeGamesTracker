package com.piriurna.freegamestracker.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

data class RoundedCornerShapes(
    val small: RoundedCornerShape= RoundedCornerShape(4.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(4.dp),
    val large: RoundedCornerShape = RoundedCornerShape(0.dp)
)

val LocalRoundedCornerShape = compositionLocalOf { RoundedCornerShapes() }
