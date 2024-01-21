package com.threemoly.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun ExampleTextField(
    visualTransformation: VisualTransformation,
    singleLine: Boolean
) {
    val textFieldState = remember { mutableStateOf(TextFieldValue("")) }
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedTextField(
            value = textFieldState.value,
            onValueChange = { newValue ->
                textFieldState.value = newValue
            },
            visualTransformation = visualTransformation,
            singleLine = singleLine
        )
        Row(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            BasicText(text = "raw value:")
            BasicText(text = textFieldState.value.text)
        }
    }
}