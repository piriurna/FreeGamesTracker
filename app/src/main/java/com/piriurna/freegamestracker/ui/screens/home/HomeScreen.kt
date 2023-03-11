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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.piriurna.domain.models.Game
import com.piriurna.freegamestracker.R
import com.piriurna.freegamestracker.ui.composables.GTBottomSheet
import com.piriurna.freegamestracker.ui.composables.card.GTCardWithBackgroundImage
import com.piriurna.freegamestracker.ui.composables.card.GTRowWithLeftImageAndDescription
import com.piriurna.freegamestracker.ui.composables.text.GTText
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.BackgroundGradientCenter
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.BackgroundGradientRadius
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.BackgroundHorizontalPadding
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.BottomSheetContentHorizontalPadding
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.BottomSheetContentTopPadding
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.BottomSheetItemSpacing
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.DefaultTitleSize
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.FreeGamesHorizontalPadding
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.FreeGamesHorizontalSpacing
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.TitleBottomPadding
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.TitleTopPadding
import com.piriurna.freegamestracker.ui.screens.home.theme.HomeScreenDimensions.UpcomingGamesItemSpacing
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
        mutableStateOf(DefaultTitleSize)
    }

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        GTBottomSheet(
            backgroundContent = {
                HomeScreenBackgroundContent(
                    paddingTop = TitleTopPadding,
                    onTitleMeasured = { size ->
                        pageTitleSize = size
                    }
                )
            },
            sheetPeekHeight = with(LocalDensity.current){
                constraints.maxHeight.toDp() - pageTitleSize.toDp() - TitleTopPadding - TitleBottomPadding
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
                    contentPadding = PaddingValues(top = BottomSheetContentTopPadding)
                ) {
                    item {
                        GTText(
                            modifier = Modifier
                                .padding(start = BottomSheetContentHorizontalPadding),
                            text = stringResource(R.string.free_games),
                            style = GTStyle.TextPlay20
                        )
                    }
                    item {
                        Spacer(
                            modifier = Modifier.height(BottomSheetItemSpacing)
                        )
                    }
                    item {
                        FreeGamesListRow(uiState.freeGames)
                    }
                    item {
                        Spacer(modifier = Modifier.height(BottomSheetItemSpacing))
                    }
                    item {
                        GTText(
                            modifier = Modifier.padding(start = BottomSheetContentHorizontalPadding),
                            text = stringResource(R.string.upcoming_games),
                            style = GTStyle.TextPlay20Bold
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(BottomSheetItemSpacing))
                    }
                    items(uiState.upcomingGames){game ->
                        GTRowWithLeftImageAndDescription(
                            modifier = Modifier.padding(horizontal = BottomSheetContentHorizontalPadding),
                            title = game.title,
                            genre = game.status,
                            gameImage = game.image,
                            rating = game.rating
                        )
                        Spacer(modifier = Modifier.height(UpcomingGamesItemSpacing))
                    }
                    item {
                        Spacer(modifier = Modifier.height(BottomSheetItemSpacing))
                    }
                }
            }
    }
}

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
                    radius = BackgroundGradientRadius,
                    center = Offset(x = BackgroundGradientCenter, y = BackgroundGradientCenter),
                    colors = listOf(
                        gradientPrimaryColor,
                        gradientBackgroundColor,
                    )
                )
            )
            .fillMaxSize()
            .padding(top = paddingTop)
            .padding(horizontal = BackgroundHorizontalPadding)

    ) {
        Column(
            modifier = Modifier.onPlaced { coordinates ->
                onTitleMeasured(coordinates.size.height.toFloat()) }
        ) {
            GTText(
                text = stringResource(R.string.home_screen_title_first_line),
                color = AppTheme.colors.onPrimary,
                style = GTStyle.TextPlay48Bold
            )

            GTText(
                text = stringResource(R.string.check_whats_currently_free),
                color = Color.White,
                style = GTStyle.TextPlay28
            )
        }
    }
}

@Composable
private fun FreeGamesListRow(gameList : List<Game>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(FreeGamesHorizontalSpacing),
        contentPadding = PaddingValues(horizontal = FreeGamesHorizontalPadding)
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