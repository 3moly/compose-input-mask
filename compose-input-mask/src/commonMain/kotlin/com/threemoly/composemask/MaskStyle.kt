package com.threemoly.composemask

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@Stable
data class MaskStyle(
    val placeholderColor: Color,
    val beforeCursorColor: Color,
    val afterCursorColor: Color
) {
    companion object {
        val Default = MaskStyle(
            placeholderColor = Color.Gray,
            beforeCursorColor = Color.Black,
            afterCursorColor = Color.Gray
        )
    }
}