package com.piriurna.freegamestracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.piriurna.freegamestracker.ui.composables.GTScaffold
import com.piriurna.freegamestracker.ui.composables.bottomnavigation.BottomNavigationItem
import com.piriurna.freegamestracker.ui.screens.home.HomeScreen
import com.piriurna.freegamestracker.ui.screens.home.HomeViewModel
import com.piriurna.freegamestracker.ui.theme.AppTheme
import com.piriurna.freegamestracker.ui.theme.FreeGamesTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeGamesTrackerTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.background
                ) {
                    val homeViewModel : HomeViewModel = hiltViewModel()
                    GTScaffold(
                        bottomNavigationItems = listOf(
                            BottomNavigationItem.HomeScreen,
                            BottomNavigationItem.SearchScreen,
                            BottomNavigationItem.FavoritesScreen
                        ),
                        navController = navController,
                    ) {
                        HomeScreen(viewModel = homeViewModel)
                    }
                }
            }
        }
    }
}
