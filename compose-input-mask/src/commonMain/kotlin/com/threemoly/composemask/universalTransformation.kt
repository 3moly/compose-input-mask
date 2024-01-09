package com.threemoly.composemask

import androidx.compose.ui.text.input.VisualTransformation

fun universalTransformation(
    mask: String,
    maskCharToKeep: Char,
    placeholder: String? = null,
    style: MaskStyle = MaskStyle.Default,
): VisualTransformation {
    return VisualTransformation {
        universalTransformedText(
            text = it.text,
            mask = mask,
            maskCharToKeep = maskCharToKeep,
            placeholder = placeholder,
            style = style
        )
    }
}

fun universalTransformation(
    mask: String,
    maskCharsToKeep: List<Char> = listOf(),
    placeholder: String? = null,
    style: MaskStyle = MaskStyle.Default,
): VisualTransformation {
    return VisualTransformation {
        universalTransformedText(
            text = it.text,
            mask = mask,
            maskCharsToKeep = maskCharsToKeep,
            placeholder = placeholder,
            style = style
        )
    }
}