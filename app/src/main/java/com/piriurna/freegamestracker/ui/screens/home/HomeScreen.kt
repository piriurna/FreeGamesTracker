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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piriurna.domain.models.Game
import com.piriurna.freegamestracker.ui.composables.GTBottomSheet
import com.piriurna.freegamestracker.ui.composables.GTScaffold
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

    val pageTitleSize by remember {
        mutableStateOf(409f)
    }
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        GTScaffold {
            GTBottomSheet(
                backgroundContent = {
                    HomeScreenBackgroundContent()
                },
                sheetPeekHeight = with(LocalDensity.current){
                    (constraints.maxHeight - pageTitleSize - 96.dp.toPx()).toDp()
                },
                sheetState = sheetState
                ) {
                    LazyColumn(
                        Modifier
                            .fillMaxSize()
                            .background(
                                color = AppTheme.colors.surface,
                                shape = if(sheetState.isExpanded) RectangleShape else AppTheme.shapes.large
                            )
                            .padding(top = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp),
                    ) {
                        item {
                            GTText(
                                modifier = Modifier.padding(start = 20.dp),
                                text = "Free Games",
                                style = GTStyle.TextPlay20
                            )
                        }
                        item {
                            FreeGamesListRow(uiState.freeGames)
                        }

                        item {
                            GTText(modifier = Modifier.padding(start = 20.dp), text = "Upcoming Games", style = GTStyle.TextPlay20Bold)
                        }

                        item {
                            UpcomingGamesListColumn(gameList = uiState.upcomingGames)
                        }
                    }
                }
        }
    }
}

@Composable
fun HomeScreenBackgroundContent() {
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
            .padding(top = 54.dp)
            .padding(horizontal = 26.dp)

    ) {
        GTText(
            text = "Welcome,",
            color = AppTheme.colors.onPrimary,
            style = GTStyle.TextPlay48Bold
        )

        GTText(
            text = "Check What's Currently Free",
            color = Color.White,
            lineHeight = 48.sp,
            style = GTStyle.TextPlay28
        )
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

@Composable
fun UpcomingGamesListColumn(gameList : List<Game>) {
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        gameList.forEach { game ->
            GTRowWithLeftImageAndDescription(
                title = game.title,
                genre = game.status,
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