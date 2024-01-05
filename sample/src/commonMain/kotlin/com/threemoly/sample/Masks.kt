package com.threemoly.sample

import androidx.compose.ui.text.input.VisualTransformation
import com.threemoly.composemask.universalTransformation

object Masks {
    val PhoneCodeMask = VisualTransformation { annotatedString ->
        universalTransformation(
            annotatedString.text,
            "(555) 495-3947",
            listOf(' ', '(', ')', '-')
        )
    }
    val PhoneWithCountryCodeMask = VisualTransformation { annotatedString ->
        universalTransformation(
            annotatedString.text,
            "+1 (555) 495-3947",
            listOf('+', '1', ' ', '(', ')', '-')
        )
    }
    val DateMask = VisualTransformation { annotatedString ->
        universalTransformation(
            annotatedString.text,
            "25/09/1970",
            listOf('/'),
            placeholder = "date's placeholder"
        )
    }
    val ZipCodeMask = VisualTransformation { annotatedString ->
        universalTransformation(
            annotatedString.text,
            "______",
            listOf(),
            placeholder = "94303"
        )
    }
}