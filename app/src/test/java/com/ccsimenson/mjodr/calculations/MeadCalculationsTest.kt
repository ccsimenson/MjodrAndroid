package com.ccsimenson.mjodr.calculations

import org.junit.Assert.*
import org.junit.Test
import kotlin.math.abs

class MeadCalculationsTest {
    private val DELTA = 0.001 // Tolerance for floating-point comparisons

    @Test
    fun testGravityTemperatureCorrection() {
        // Test standard temperature correction
        val gravity = 1.050
        val measuredTemp = 70.0
        val expected = 1.051 // Same as iOS test case
        val result = MeadCalculations.correctGravityForTemperature(gravity, measuredTemp)
        assertEquals(expected, result, DELTA)

        // Test no correction needed
        val resultNoCorrection = MeadCalculations.correctGravityForTemperature(gravity, 60.0)
        assertEquals(gravity, resultNoCorrection, DELTA)
    }

    @Test
    fun testStandardABVCalculation() {
        val og = 1.055
        val fg = 1.015
        val expected = 5.25 // (1.055 - 1.015) * 131.25, same as iOS test case
        val result = MeadCalculations.calculateABVStandard(og, fg)
        assertEquals(expected, result, DELTA)
    }

    @Test
    fun testAdvancedABVCalculation() {
        val og = 1.120
        val fg = 1.030
        val result = MeadCalculations.calculateABVAdvanced(og, fg)
        // Same validation as iOS: ensure result is within reasonable range
        assertTrue(result > 0)
        assertTrue(result < 30)
    }

    @Test
    fun testGravityToPlato() {
        val gravity = 1.040
        val expected = 10.0 // Same as iOS test case
        val result = MeadCalculations.gravityToPlato(gravity)
        assertTrue(abs(expected - result) <= 0.5)
    }
}
