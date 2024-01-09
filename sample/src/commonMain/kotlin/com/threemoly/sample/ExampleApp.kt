package com.threemoly.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.threemoly.composemask.universalTransformedText

@Composable
fun ExampleTextField(
    visualTransformation: VisualTransformation,
    singleLine: Boolean
) {
    val textFieldValue = remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        BasicTextField(
            value = textFieldValue.value,
            onValueChange = {
                textFieldValue.value = it
            },
            visualTransformation = visualTransformation,
            singleLine = singleLine,
            decorationBox = {
                Box(Modifier.background(Color.White).padding(8.dp)) {
                    it()
                }
            }
        )
        Row(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            BasicText(text = "raw value:")
            BasicText(text = textFieldValue.value)
        }
    }
}

@Composable
fun ExampleApp() {
    SampleTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
                .statusBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ExampleTextField(
                singleLine = true,
                visualTransformation = Masks.PhoneCodeMask
            )
            ExampleTextField(
                singleLine = true,
                visualTransformation = Masks.PhoneWithCountryCodeMask
            )
            ExampleTextField(
                singleLine = true,
                visualTransformation = Masks.DateMask
            )
            ExampleTextField(
                singleLine = true,
                visualTransformation = Masks.ZipCodeMask
            )
            ExampleTextField(
                singleLine = false,
                visualTransformation = {
                    universalTransformedText(
                        it.text,
                        """Fill the field
                                            |
                                            |
                                            |0000-0000
                                        """.trimMargin(),
                        listOf('-', '\n')
                    )
                },
            )
        }
    }
}