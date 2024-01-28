package com.threemoly.sample

import com.threemoly.composemask.universalTransformation

object Masks {
    val phoneCode = universalTransformation(
        mask = "(000) 000-0000",
        maskCharsToKeep = listOf(' ', '(', ')', '-')
    )
    val phoneWithCountryCode = universalTransformation(
        mask = "+1 (555) 495-3947",
        maskCharsToKeep = listOf('+', '1', ' ', '(', ')', '-')
    )
    val date = universalTransformation(
        mask = "25/09/1970",
        maskCharToKeep = '/'
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