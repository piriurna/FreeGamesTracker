package com.piriurna.freegamestracker.ui.composables.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.piriurna.freegamestracker.R
import com.piriurna.freegamestracker.ui.composables.rating.GTStarRating
import com.piriurna.freegamestracker.ui.composables.text.GTText
import com.piriurna.freegamestracker.ui.theme.AppTheme
import com.piriurna.freegamestracker.ui.theme.GTStyle.TextPlay20
import com.piriurna.freegamestracker.ui.theme.Gray

@Composable
fun GTRowWithLeftImageAndDescription(
    modifier: Modifier = Modifier,
    title: String,
    genre: String,
    rating: Float? = null,
    placeHolder: Int = R.drawable.ic_launcher_background,
    gameImage: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = AppTheme.shapes.medium,
        elevation = 8.dp,
        backgroundColor = AppTheme.colors.overlay
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            val request = ImageRequest
                .Builder(LocalContext.current)
                .data(gameImage)
                .crossfade(false)
                .placeholder(placeHolder)
                .build()

            AsyncImage(
                modifier = Modifier
                .padding(top = 20.dp)
                .clip(shape = AppTheme.shapes.medium)
                .size(64.dp)
                .fillMaxHeight(),
                contentScale = ContentScale.Crop,
                model = request,
                contentDescription = stringResource(R.string.game_icon)
            )
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
            ) {
                GTText(
                    text = title,
                    style = TextPlay20,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                GTText(
                    text = genre,
                    color = Gray
                )
                rating?.let {
                    GTStarRating(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .padding(top = 8.dp),
                        rating = rating,
                        spaceBetween = 4.dp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GTRowWithLeftImageAndDescriptionPreview() {
    AppTheme {
        GTRowWithLeftImageAndDescription(title = "GTA4", genre = "Action", rating = 4.5f, gameImage = "https://icons.iconarchive.com/icons/th3-prophetman/gta/256/IV-icon.png")
        GTRowWithLeftImageAndDescription(title = "Cyberpunk 2077", genre = "Adventure", rating = 2.5f, gameImage = "https://i1.modland.net/i/5fbcd2b1dc19b/7-1607466256-704411499-lg_modland.webp")
        GTRowWithLeftImageAndDescription(title = "Risk of Rain 2", genre = "Roguelike", rating = 4.3f, gameImage = "https://play-lh.googleusercontent.com/lFo5oh3FSkfTz81H6WCedSwDL7tTxq34itYdY05DJVyvfjzOw2SjcvIRO1VqT1Xb3X8")
    }
}
