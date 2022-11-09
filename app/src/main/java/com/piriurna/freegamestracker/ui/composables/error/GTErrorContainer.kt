package com.piriurna.freegamestracker.ui.composables.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piriurna.freegamestracker.ui.composables.button.GTButton
import com.piriurna.freegamestracker.ui.composables.text.GTText
import com.piriurna.freegamestracker.ui.theme.GTStyle

@Composable
fun GTErrorContainer(
    modifier : Modifier = Modifier,
    imageResource : Int,
    title: String,
    subtitle : String,
    hasButton : Boolean,
    buttonText : String,
    buttonBackgroundColor : Color = MaterialTheme.colors.primary,
    buttonTextColor : Color = MaterialTheme.colors.onPrimary,
    buttonModifier: Modifier = Modifier.fillMaxWidth(0.5f),
    buttonOnClick : () -> Unit = {}
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = imageResource),
            contentDescription = "Error Image",
            colorFilter = ColorFilter.tint(buttonTextColor)
        )

        GTText(text = title, style = GTStyle.TextPlay28)

        GTText(text = subtitle, style = GTStyle.TextPlay20)

        if(hasButton)
            GTButton(modifier = buttonModifier, onClick = buttonOnClick, buttonText = buttonText, textColor = buttonTextColor, backgroundColor = buttonBackgroundColor, foregroundColor = buttonTextColor)
    }
}

@Preview(showBackground = true)
@Composable
fun GTErrorContainerPreview() {
    GTErrorContainer(
        imageResource = com.piriurna.freegamestracker.R.drawable.ic_disconnected,
        title = "Error!",
        subtitle = "No Internet Connection",
        buttonText = "RETRY",
        hasButton = true,
        buttonOnClick = {}
    )
}