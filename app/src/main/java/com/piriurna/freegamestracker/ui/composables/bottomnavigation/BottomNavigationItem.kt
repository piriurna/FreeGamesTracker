package com.piriurna.freegamestracker.ui.composables.bottomnavigation

import androidx.annotation.DrawableRes
import com.piriurna.freegamestracker.R

sealed class BottomNavigationItem(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int
) {

    object HomeScreen: BottomNavigationItem(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home
    )

    object SearchScreen: BottomNavigationItem(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_search
    )

    object FavoritesScreen: BottomNavigationItem(
        route = "favorites",
        title = "Favorites",
        icon = R.drawable.ic_favorites
    )
}