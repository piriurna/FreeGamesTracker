package com.piriurna.freegamestracker.ui.screens.home

import com.piriurna.domain.models.Game
import com.piriurna.freegamestracker.UiState

data class HomeUiState(
    val isLoading: Boolean = false,
    val freeGames : List<Game> = emptyList(),
    val upcomingGames: List<Game> = emptyList()
) : UiState()