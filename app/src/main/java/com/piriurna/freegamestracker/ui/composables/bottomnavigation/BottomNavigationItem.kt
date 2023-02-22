package com.piriurna.freegamestracker.ui.composables.bottomnavigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.piriurna.freegamestracker.ui.models.BottomNavItem
import com.piriurna.freegamestracker.ui.theme.AppTheme

@Composable
fun BottomNavigationBar(
    navItems: List<BottomNavItem>,
    bottomBarHeight: Dp,
    bottomBarOffsetHeightPx: Int,
    selectedRoute: String,
    setSelectedRoute: (BottomNavItem) -> Unit,
    itemSize: Dp = 28.dp
) {
    BottomNavigation(
        Modifier
            .graphicsLayer {
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                clip= true
            }
            .height(bottomBarHeight)
            .offset { IntOffset(x = 0, y = -bottomBarOffsetHeightPx) }
        ,
        backgroundColor = AppTheme.colors.surface,
        elevation = 8.dp,
        contentColor = AppTheme.colors.primary,
    ) {
        navItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    item.icon?.let {
                        Icon(
                            modifier = Modifier.size(itemSize),
                            painter = painterResource(it),
                            contentDescription = item.title,
                        )
                    }
                },
                selected = selectedRoute == item.route,
                onClick = {
                    setSelectedRoute(item)
                }
            )
        }
    }
}