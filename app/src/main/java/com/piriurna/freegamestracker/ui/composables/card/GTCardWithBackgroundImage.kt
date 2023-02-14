package com.piriurna.freegamestracker.ui.composables.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.piriurna.domain.models.GiveawayGame
import com.piriurna.freegamestracker.R
import com.piriurna.freegamestracker.ui.composables.preview.GTThemedPreviewColumn
import com.piriurna.freegamestracker.ui.composables.text.GTText
import com.piriurna.freegamestracker.ui.theme.DropDownGradient
import com.piriurna.freegamestracker.ui.theme.GTStyle.TextPlay20

@Composable
fun GTCardWithBackgroundImage(
    modifier: Modifier = Modifier,
    title: String,
    rating: Float,
    gameImage: String,
    placeholder: Int = R.drawable.ic_launcher_background
) {
    Card(
        modifier = modifier
            .height(160.dp)
            .width(330.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp
    ) {
        val request = ImageRequest
            .Builder(LocalContext.current)
            .data(gameImage)
            .crossfade(false)
            .placeholder(placeholder)
            .build()

        AsyncImage(
            modifier = Modifier
                .clip(shape = MaterialTheme.shapes.medium)
                .fillMaxHeight()
                .fillMaxWidth(),
            model = request,
            contentDescription = stringResource(R.string.game_image),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = DropDownGradient
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 8.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            GTText(text = title, style = TextPlay20, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Row {
                Image(
                    modifier = Modifier
                        .padding(top = 5.dp, end = 4.dp)
                        .size(16.dp),
                    painter = painterResource(
                    id = R.drawable.ic_star_rating_full),
                    contentDescription = stringResource(R.string.rating_star),
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
                )
                GTText(text = rating.toString(), style = TextPlay20)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GTCardWithBackgroundImagePreview() {
    GTThemedPreviewColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val mock = GiveawayGame.mocks[0]
        GTCardWithBackgroundImage(title = mock.title, rating = 3.5f, gameImage = mock.image)
    }
}