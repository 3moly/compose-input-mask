package com.threemoly.sample

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MaskOption(isSelected: Boolean, text: AnnotatedString, onSelected: () -> Unit) {
    val surfaceColor = remember(isSelected) {
        if (isSelected) {
            Color(0xFF8cfa9b)
        } else {
            Color(0xffe0e0e0)
        }
    }
    Surface(modifier = Modifier, shape = RoundedCornerShape(8.dp), onClick = {
        onSelected()
    }, color = surfaceColor) {
        Text(
            text = text,
            modifier = Modifier.padding(8.dp)
        )
    }
}