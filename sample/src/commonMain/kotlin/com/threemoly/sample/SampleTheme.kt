package com.threemoly.sample

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
internal fun SampleTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = Colors(
            primary = Color.Black,
            background = Color.Red,
            primaryVariant = Color.Yellow,
            secondary = Color.Green,
            secondaryVariant = Color.Blue,
            surface = Color.LightGray,
            error = Color.Red,
            onPrimary = Color.Magenta,
            onSecondary = Color.Cyan,
            onBackground = Color.LightGray,
            onSurface = Color.Blue,
            onError = Color.Red,
            isLight = true
        ),
        content = content
    )
}