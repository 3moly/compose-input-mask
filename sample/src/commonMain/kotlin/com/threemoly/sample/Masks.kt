package com.threemoly.sample

import androidx.compose.ui.graphics.Color
import com.threemoly.composemask.MaskStyle
import com.threemoly.composemask.universalTransformation

object Masks {
    val phoneCode = universalTransformation(
        mask = "(000) 000-0000",
        maskCharsToKeep = listOf(' ', '(', ')', '-'),
        placeholder = "date's placeholder"
    )
    val phoneWithCountryCode = universalTransformation(
        mask = "+1 (555) 495-3947",
        maskCharsToKeep = listOf('+', '1', ' ', '(', ')', '-')
    )
    val date = universalTransformation(
        mask = "25/09/1970",
        maskCharToKeep = '/',
        placeholder = "date's placeholder",
        style = MaskStyle(
            placeholderColor = Color.Magenta,
            beforeCursorColor = Color.Green,
            afterCursorColor = Color.Red
        )
    )
    val zipCode = universalTransformation(
        mask = "dd/mm/yyyy",
        maskCharsToKeep = listOf('/')
    )
    val ip = universalTransformation(
        mask = "___.___.___.___",
        maskCharsToKeep = listOf('.')
    )
    val creditCard = universalTransformation(
        mask = "____ ____ ____ ____",
        maskCharsToKeep = listOf(' ')
    )
}