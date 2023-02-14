package com.piriurna.freegamestracker.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.piriurna.freegamestracker.ui.composables.error.GTErrorContainer
import com.piriurna.freegamestracker.ui.composables.loading.GTLoading
import com.piriurna.freegamestracker.ui.models.GTError
import com.piriurna.freegamestracker.ui.theme.AppTheme
import com.piriurna.freegamestracker.ui.theme.FreeGamesTrackerTheme


@Composable
fun GTScaffold(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    error : GTError? = null,
    navController: NavHostController? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    val bottomBarHeight = 52.dp

    val bottomBarHeightPx = with(LocalDensity.current) {
        bottomBarHeight.roundToPx().toFloat()
    }
    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                val delta = available.y
                val newOffset = bottomBarOffsetHeightPx.value + delta
                bottomBarOffsetHeightPx.value =
                    newOffset.coerceIn(-bottomBarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        val scaffoldModifier = modifier.fillMaxSize()
        Scaffold(
            modifier = scaffoldModifier.nestedScroll(nestedScrollConnection),
            content = content,
        )

        GTLoading(isLoading = isLoading)

        if(error != null && !isLoading){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(enabled = false, onClick = {})
                    .background(AppTheme.colors.background.copy(alpha = 0.8f))
                    .align(Alignment.Center),
                contentAlignment = Alignment.Center
            ) {
                GTErrorContainer(
                    imageResource = error.imageResource,
                    title = stringResource(id = error.title),
                    subtitle = stringResource(id = error.subtitle),
                    hasButton = error.canRetry,
                    buttonOnClick = error.onRetry,
                    buttonText = stringResource(id = error.retryText),
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SQScaffoldPreview() {
    FreeGamesTrackerTheme() {
        GTScaffold(
            isLoading = true,
            error = null,
        ) {
            Text(text = "Scaffold test")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SQScaffoldErrorPreview() {
    FreeGamesTrackerTheme() {
        GTScaffold(
            isLoading = false,
            error = GTError.GenericError {},
        ) {
            Text(text = "Scaffold test")
        }
    }
}