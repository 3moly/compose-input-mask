package com.threemoly.composemask

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.test.Test
import kotlin.test.assertEquals

class TransformedTextTest {

    private val birthdayMask = "__.__.____"

    @Test
    fun test_blank() {
        val transformedText = universalTransformedText("", "", maskCharsToKeep = listOf())
        assertEquals("", transformedText.text.text)
    }

    @Test
    fun test_transformed_text() {
        val transformedText = universalTransformedText("22335555", birthdayMask, maskCharToKeep = '.')
        assertEquals("22.33.5555", transformedText.text.text)
    }

    @Test
    fun test_transformed_text_filled() {
        val transformedText = universalTransformedText("2233555566", birthdayMask, maskCharToKeep = '.')
        assertEquals("22.33.5555", transformedText.text.text)
    }

    @Test
    fun test_empty_mask_but_text() {
        val transformedText = universalTransformedText("2233", "", maskCharToKeep = '.')
        assertEquals("", transformedText.text.text)
    }

    @Test
    fun test_empty_mask_but_all_mask_chars_kept() {
        val transformedText =
            universalTransformedText("22335555", birthdayMask, maskCharsToKeep = listOf('.', '_'))
        assertEquals(birthdayMask, transformedText.text.text)
    }

    @Test
    fun test_empty_mask_but_all_mask_chars_kept_2() {
        val visual = VisualTransformation {
            universalTransformedText(it.text, birthdayMask, maskCharsToKeep = listOf('.'))
        }
        val transformedText = visual.filter(AnnotatedString("88"))
//        val transform
//
//        edText =
//            universalTransformation("22335555", birthdayMask, maskCharsToKeep = listOf('.', '_'))
        assertEquals("88.__.____", transformedText.text.text)
    }
}