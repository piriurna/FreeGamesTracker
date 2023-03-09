package com.piriurna.freegamestracker.ui.composables.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.piriurna.freegamestracker.ui.theme.AppTheme

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedRoute: String,
    onRouteSelected: (String) -> Unit,
    bottomBarHeight: Dp = 56.dp
) {
    BoxWithConstraints {
        var selectedRouteIndex by remember {
            mutableStateOf(getIndexFromSelectedRoute(items, selectedRoute))
        }

        LaunchedEffect(selectedRoute) {
            selectedRouteIndex = getIndexFromSelectedRoute(items, selectedRoute)
        }

        val itemWidth = remember {
            derivedStateOf {
                maxWidth / items.size
            }
        }

        val dotPosition = animateDpAsState(
            targetValue = itemWidth.value * selectedRouteIndex - itemWidth.value / 2
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = AppTheme.colors.overlay,
                    shape = RoundedCornerShape(topStartPercent = 25, topEndPercent = 25)
                ),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(bottomBarHeight),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEach { item ->
                    BottomNavigationItem(
                        modifier = Modifier
                            .weight(1f),
                        icon = item.icon,
                        isSelected = item.route == selectedRoute,
                        onClick = {
                            onRouteSelected(item.route)
                        }
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .offset(x = dotPosition.value)
                    .size(8.dp)
                    .background(AppTheme.colors.primary, shape = CircleShape)
                ,
            )
        }
    }
}

@Composable
fun BottomNavigationItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint( if(isSelected) AppTheme.colors.primary else AppTheme.colors.onBackground )
        )
    }
}

private fun getIndexFromSelectedRoute(
    items: List<BottomNavigationItem>,
    selectedRoute: String
): Int {
    return items.indexOfFirst { it.route == selectedRoute } + 1
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    var selectedRoute by remember {
        mutableStateOf("search")
    }
    AppTheme {
        BottomNavigationBar(
            items = listOf(
                BottomNavigationItem.HomeScreen,
                BottomNavigationItem.SearchScreen,
                BottomNavigationItem.FavoritesScreen
            ),
            selectedRoute = selectedRoute,
            onRouteSelected = {
                selectedRoute = it
            }
        )
    }
}