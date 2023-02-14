package com.piriurna.freegamestracker.ui.composables.rating

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.piriurna.freegamestracker.R
import com.piriurna.freegamestracker.ui.composables.preview.GTThemedPreviewColumn
import com.piriurna.freegamestracker.ui.composables.rating.models.StarType
import com.piriurna.freegamestracker.ui.theme.AppTheme

@Composable
fun GTStarRating(
    modifier: Modifier = Modifier,
    rating: Float,
    spaceBetween: Dp = 8.dp,
    totalCount : Int = 5,
    filledStar : Int = R.drawable.ic_star_rating_full,
    emptyStar: Int = R.drawable.ic_star_rating_empty,
    starColor : Color = AppTheme.colors.rating
) {

    BoxWithConstraints(
        modifier = modifier
    ) {
        with(LocalDensity.current){
            val actualWidth = constraints.maxWidth - (spaceBetween.toPx() * (totalCount - 1))
            val imageSize = actualWidth / totalCount

            Box {
                //DRAW ALL THE EMPTY RATING STARS
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .fillMaxWidth()
                        .drawWithContent {
                            setBounds(
                                totalCount,
                                rating,
                                imageSize,
                                spaceBetween.toPx(),
                                StarType.Empty
                            )
                        },
                    horizontalArrangement = Arrangement.spacedBy(spaceBetween)
                ) {
                    for(i in 1..totalCount) {
                        Image(
                            modifier = Modifier.size(imageSize.toDp()),
                            colorFilter = ColorFilter.tint(starColor),
                            painter = painterResource(id = emptyStar),
                            contentDescription = stringResource(R.string.empty_star)
                        )
                    }
                }

                //DRAW ALL THE FILLED RATING STARS
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .fillMaxWidth()
                        .drawWithContent {
                            setBounds(
                                totalCount,
                                rating,
                                imageSize,
                                spaceBetween.toPx(),
                                StarType.Filled
                            )
                        },
                    horizontalArrangement = Arrangement.spacedBy(spaceBetween)
                ) {
                    for(i in 1..totalCount) {
                        Image(
                            modifier = Modifier.size(imageSize.toDp()),
                            colorFilter = ColorFilter.tint(starColor),
                            painter = painterResource(id = filledStar),
                            contentDescription = stringResource(R.string.full_star)
                        )
                    }
                }

            }
        }
    }
}


private fun ContentDrawScope.setBounds(totalCount: Int, rating : Float, imageSize : Float, spacing : Float, starType: StarType) {
    val remaining = rating - rating.toInt()
    val completeStars = (rating - remaining).toInt()

    val start = if(starType == StarType.Empty) rating * imageSize + completeStars * spacing else 0f

    val end = if(starType == StarType.Empty) {
        imageSize * totalCount + spacing * (totalCount - 1)
    } else {
        rating * imageSize + completeStars * spacing
    }


    clipRect(
        left = start,
        top = 0f,
        right = end,
        bottom = imageSize
    ) {
        this@setBounds.drawContent()
    }
}

@Preview
@Composable
private fun GTStarRatingPreview() {
    GTThemedPreviewColumn() {
        GTStarRating(rating = 1.3f, modifier = Modifier.fillMaxWidth())

        GTStarRating(rating = 1.3f, modifier = Modifier.fillMaxWidth())

        GTStarRating(rating = 1.3f, modifier = Modifier.fillMaxWidth())
    }
}