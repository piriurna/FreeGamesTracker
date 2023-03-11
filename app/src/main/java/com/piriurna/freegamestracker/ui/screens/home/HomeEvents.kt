package com.piriurna.freegamestracker.ui.screens.home

import com.piriurna.freegamestracker.BaseEvent

sealed class HomeEvents : BaseEvent() {

    object LoadGames : HomeEvents()
}