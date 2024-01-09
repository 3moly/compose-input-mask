package com.threemoly.composemask

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText

fun universalTransformedText(
    text: String,
    mask: String,
    maskCharToKeep: Char,
    placeholder: String? = null,
    style: MaskStyle = MaskStyle.Default,
): TransformedText {
    return universalTransformedText(
        text = text,
        style = style,
        mask = mask,
        maskCharsToKeep = listOf(maskCharToKeep),
        placeholder = placeholder
    )
}

fun universalTransformedText(
    text: String,
    mask: String,
    maskCharsToKeep: List<Char> = listOf(),
    placeholder: String? = null,
    style: MaskStyle = MaskStyle.Default,
): TransformedText {

    val isShowPlaceholder = text.isEmpty() && placeholder != null

    val offsetMapping = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            var textOffset = 0
            for (i in mask.indices) {
                var isSpace = false
                for (char in maskCharsToKeep) {
                    if (mask[i] == char) {
                        isSpace = true
                        break
                    }
                }
                if (!isSpace) {
                    if (offset == textOffset) {
                        return i
                    }
                    if (text.length == textOffset) {
                        break
                    }
                    textOffset++
                }
            }
            return mask.length
        }

        override fun transformedToOriginal(offset: Int): Int {
            var newOffset = 0
            if (!isShowPlaceholder) {
                for (i in 0 until offset) {
                    for (space in maskCharsToKeep) {
                        if (mask[i] == space) {
                            newOffset -= 1
                            break
                        }
                    }
                    newOffset += 1
                }
                newOffset =
                    if (newOffset > text.length)
                        text.length
                    else
                        newOffset
            }
            return newOffset
        }
    }

    val annotatedString = AnnotatedString.Builder().run {
        if (isShowPlaceholder) {
            pushStyle(SpanStyle(color = style.placeholderColor))
            append(placeholder)
        } else {
            var textOffset = 0
            pushStyle(SpanStyle(color = style.beforeCursorColor))
            for (i in mask.indices) {
                var isSpace = false
                for (space in maskCharsToKeep) {
                    if (mask[i] == space) {
                        append(space)
                        isSpace = true
                        break
                    }
                }
                if (!isSpace) {
                    if (text.length == textOffset) {
                        break
                    }
                    append(text[textOffset])
                    textOffset++
                }
            }
            pushStyle(SpanStyle(color = style.afterCursorColor))
            if (mask.length - length > 0)
                append(mask.takeLast(mask.length - length))

        }
        toAnnotatedString()
    }

    return TransformedText(annotatedString, offsetMapping)
}