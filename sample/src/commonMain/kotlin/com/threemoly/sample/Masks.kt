package com.threemoly.sample

import com.threemoly.composemask.universalTransformation

object Masks {
    val PhoneCodeMask = universalTransformation(
        mask = "(555) 495-3947",
        maskCharsToKeep = listOf(' ', '(', ')', '-')
    )
    val PhoneWithCountryCodeMask = universalTransformation(
        mask = "+1 (555) 495-3947",
        maskCharsToKeep = listOf('+', '1', ' ', '(', ')', '-')
    )
    val DateMask = universalTransformation(
        mask = "25/09/1970",
        maskCharToKeep = '/',
        placeholder = "date's placeholder"
    )
    val ZipCodeMask = universalTransformation(
        mask = "25/09/1970",
        maskCharsToKeep = listOf('/'),
        placeholder = "date's placeholder"
    )
}