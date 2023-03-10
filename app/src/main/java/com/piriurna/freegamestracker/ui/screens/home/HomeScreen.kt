package com.piriurna.freegamestracker.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.piriurna.domain.models.Game
import com.piriurna.freegamestracker.ui.composables.GTBottomSheet
import com.piriurna.freegamestracker.ui.composables.card.GTCardWithBackgroundImage
import com.piriurna.freegamestracker.ui.composables.card.GTRowWithLeftImageAndDescription
import com.piriurna.freegamestracker.ui.composables.text.GTText
import com.piriurna.freegamestracker.ui.theme.AppTheme
import com.piriurna.freegamestracker.ui.theme.GTStyle
import com.piriurna.freegamestracker.ui.theme.gradientBackgroundColor
import com.piriurna.freegamestracker.ui.theme.gradientPrimaryColor

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val uiState = viewModel.uiState.value

    HomeScreenContent(uiState = uiState)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun HomeScreenContent(uiState: HomeUiState) {
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)

    var pageTitleSize by remember {
        mutableStateOf(490f)
    }

    val titleTopPadding = 56.dp
    val titleBottomPadding = 46.dp
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        GTBottomSheet(
            backgroundContent = {
                HomeScreenBackgroundContent(
                    paddingTop = titleTopPadding,
                    onTitleMeasured = { size ->
                        pageTitleSize = size
                    }
                )
            },
            sheetPeekHeight = with(LocalDensity.current){
                constraints.maxHeight.toDp() - pageTitleSize.toDp() - titleTopPadding - titleBottomPadding
            },
            sheetState = sheetState
            ) {
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .background(
                            color = AppTheme.colors.surface,
                            shape = if (sheetState.isExpanded) RectangleShape else AppTheme.shapes.large
                        ),
                    contentPadding = PaddingValues(top = 28.dp)
                ) {
                    item {
                        GTText(
                            modifier = Modifier.padding(start = 20.dp),
                            text = "Free Games",
                            style = GTStyle.TextPlay20
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                    item {
                        FreeGamesListRow(uiState.freeGames)
                    }
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                    item {
                        GTText(
                            modifier = Modifier.padding(start = 20.dp),
                            text = "Upcoming Games",
                            style = GTStyle.TextPlay20Bold
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                    items(uiState.upcomingGames){game ->
                        GTRowWithLeftImageAndDescription(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            title = game.title,
                            genre = game.status,
                            gameImage = game.image,
                            rating = game.rating
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun HomeScreenBackgroundContent(
    onTitleMeasured: (Float) -> Unit,
    paddingTop: Dp
) {
    Column(
        verticalArrangement= Arrangement.Top,
        modifier = Modifier
            .background(
                brush = Brush.radialGradient(
                    radius = 900f,
                    center = Offset(x = 350f, y = 350f),
                    colors = listOf(
                        gradientPrimaryColor,
                        gradientBackgroundColor,
                    )
                )
            )
            .fillMaxSize()
            .padding(top = paddingTop)
            .padding(horizontal = 26.dp)

    ) {
        Column(
            modifier = Modifier.onPlaced { coordinates ->
                onTitleMeasured(coordinates.size.height.toFloat()) }
        ) {
            GTText(
                text = "Welcome,",
                color = AppTheme.colors.onPrimary,
                style = GTStyle.TextPlay48Bold
            )

            GTText(
                text = "Check What's Currently Free",
                color = Color.White,
                lineHeight = TextUnit(35f, TextUnitType.Sp),
                style = GTStyle.TextPlay28
            )
        }
    }
}

@Composable
private fun FreeGamesListRow(gameList : List<Game>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        items(gameList) { game ->
            GTCardWithBackgroundImage(
                title = game.title,
                gameImage = game.image,
                rating = game.rating
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AppTheme {
        HomeScreenContent(uiState = HomeUiState(
            freeGames = Game.mocks,
            upcomingGames = Game.mocks
        ))
    }

}