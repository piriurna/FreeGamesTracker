package com.piriurna.freegamestracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.piriurna.freegamestracker.ui.composables.GTScaffold
import com.piriurna.freegamestracker.ui.models.BottomNavItem
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colors.background
                ) {
                    val (selectedItemIndex, setSelectedItemIndex) = remember { mutableStateOf(0) }
                    val homeViewModel : HomeViewModel = hiltViewModel()
                    GTScaffold(
                        bottomNavigationItems = BottomNavItem.dummy,
                        selectedBottomNavItem = BottomNavItem.dummy[selectedItemIndex],
                        setSelectedBottomNavigationItem = { item -> setSelectedItemIndex(BottomNavItem.dummy.indexOf(item)) }
                    ) {
                        HomeScreen(viewModel = homeViewModel)
                    }
                }
            }
        }
    }
}
