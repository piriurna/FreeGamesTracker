package com.piriurna.freegamestracker.ui.models

import com.piriurna.freegamestracker.R

data class BottomNavItem(
    val title: String,
    val icon: Int?,
    val route: String
) {
    companion object {
        val dummy = listOf(
            BottomNavItem(
                "Home",
                icon = R.drawable.ic_home,
                route = "home_screen"
            ),
            BottomNavItem(
                "Search",
                icon = R.drawable.ic_search,
                route = "search_screen"
            ),
            BottomNavItem(
                "Account",
                icon = R.drawable.ic_favorites,
                route = "account_screen"
            )
        )
    }
}