package com.piriurna.freegamestracker.ui.composables.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piriurna.freegamestracker.ui.composables.text.GTText
import com.piriurna.freegamestracker.ui.theme.AppTheme
import com.piriurna.freegamestracker.ui.theme.GTStyle

@Composable
fun GTButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick : () -> Unit,
    backgroundColor : Color = AppTheme.colors.primary,
    foregroundColor: Color = AppTheme.colors.onPrimary,
    buttonText: String,
    textColor : Color = Color.White,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor, contentColor = foregroundColor),
        enabled = enabled,
        modifier = modifier
            .height(45.dp)
    ) {
        GTText(
            text = buttonText,
            color = textColor,
            style = GTStyle.TextPlay
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GTButtonPreview() {
    GTButton(onClick = {}, buttonText = "Get Started")
}