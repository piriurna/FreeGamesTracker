package com.piriurna.freegamestracker.ui.composables.loading

import androidx.annotation.RawRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.piriurna.freegamestracker.R
import com.piriurna.freegamestracker.ui.composables.animations.GTLottieLoading
import com.piriurna.freegamestracker.ui.theme.AppTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GTLoading(
    isLoading: Boolean,
    @RawRes lottieId: Int = R.raw.loading,
) {
    AnimatedVisibility(
        modifier = Modifier.fillMaxSize(),
        visible = isLoading,
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(enabled = false, onClick = {})
                .background(AppTheme.colors.background.copy(alpha = 0.8f)),
            contentAlignment = Alignment.Center
        ) {
            GTLottieLoading(lottieId= lottieId)
        }
    }
}


@Preview
@Composable
fun GTLoadingPreview() {
    GTLoading(isLoading = true)
}