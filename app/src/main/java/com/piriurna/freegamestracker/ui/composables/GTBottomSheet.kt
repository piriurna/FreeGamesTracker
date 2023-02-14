package com.piriurna.freegamestracker.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GTBottomSheet(
    modifier: Modifier = Modifier,
    backgroundContent: @Composable (PaddingValues) -> Unit,
    sheetState: BottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed),
    sheetPeekHeight: Dp,
    sheetContent: @Composable ColumnScope.() -> Unit,
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        content = backgroundContent,
        sheetContent = {
            sheetContent.invoke(this)
        },
        sheetBackgroundColor = Color.Transparent,
        sheetPeekHeight = sheetPeekHeight
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun GTBottomSheetPreview() {
    GTBottomSheet(
        sheetContent = {
            Card(
                shape = RoundedCornerShape(
                    topStartPercent = 15,
                    topEndPercent = 15
                ),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Bottom sheet test"
                    )
                }
            }

        },
        backgroundContent = {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {

            }
        },
        sheetPeekHeight = 450.dp,
    )
}