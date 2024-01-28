package com.threemoly.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun ExampleApp() {
    val masks = remember {
        listOf(
            Masks.date,
            Masks.phoneCode,
            Masks.zipCode,
            Masks.phoneWithCountryCode,
            Masks.ip,
            Masks.creditCard,
        )
    }
    val selectedMask = remember {
        mutableStateOf<VisualTransformation?>(null)
    }
    SampleTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .statusBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FlowRow(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    for (item in masks) {
                        MaskOption(
                            isSelected = selectedMask.value == item,
                            text = item.filter(AnnotatedString("")).text,
                            onSelected = {
                                selectedMask.value = item
                            })
                    }
                }
                if (selectedMask.value != null) {
                    ExampleTextField(
                        singleLine = true,
                        visualTransformation = selectedMask.value!!
                    )
                }
            }
        }
    }
}