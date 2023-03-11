package com.piriurna.freegamestracker.ui.screens.home

import com.piriurna.domain.models.Game
import com.piriurna.freegamestracker.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): BaseViewModel<HomeEvents, HomeUiState>() {

    init {
        loadGames()
    }

    override fun onEventTriggered(event: HomeEvents) {
        when (event) {
            is HomeEvents.LoadGames -> {
                loadGames()
            }
        }
    }

    private fun loadGames() {
        updateStateTo(uiState.value.copy(
            isLoading = false,
            upcomingGames = Game.mocks,
            freeGames = Game.mocks
        ))
    }

    override fun initialState() = HomeUiState()
}