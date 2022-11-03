package com.piriurna.freegamestracker.ui.composables.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piriurna.freegamestracker.ui.composables.text.GTText
import com.piriurna.freegamestracker.ui.theme.GTStyle.TextPlay20
import com.piriurna.freegamestracker.ui.theme.Gray

@Composable
fun GTGameRow(
    modifier: Modifier = Modifier,
    title: String = "GTA4",
    genre: String = "Ação",
    rating: Double = 4.5,
    gameImageId: Int = com.piriurna.freegamestracker.R.drawable.ic_launcher_background,
    // TODO gameImage: String = "URL"
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(108.dp),

        backgroundColor = Color(red = 70, green = 63, blue = 113),
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            //image here
            Image(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .clip(shape = MaterialTheme.shapes.medium)
                    .fillMaxHeight(),
                painter = painterResource(id = gameImageId),
                contentDescription = "game icon"
            )
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
            ) {

                GTText(text = title, style = TextPlay20, maxLines = 1, overflow = TextOverflow.Ellipsis)
                GTText(text = genre, color = Gray)
                GTText(modifier = Modifier.padding(top = 4.dp),text = rating.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GTGameRowPreview() {
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        GTGameRow()
        GTGameRow()
        GTGameRow()
    }
}