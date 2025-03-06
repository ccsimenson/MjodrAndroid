package com.ccsimenson.mjodr.utils

/**
 * Viking-themed ABV calculator utility class
 * Implements the standard ABV formula: (OG - FG) × 131.25
 * Example usage: OG=1.055, FG=1.015 yielding 5.25% ABV
 */
object AbvCalculator {
    /**
     * Calculate ABV (Alcohol By Volume) from original and final gravity
     * @param og Original gravity (e.g., 1.055)
     * @param fg Final gravity (e.g., 1.015)
     * @param temperature Temperature in Fahrenheit (default 60°F)
     * @return ABV percentage
     */
    fun calculateAbv(og: Float, fg: Float, temperature: Float = 60f): Float {
        // Temperature correction (if not at 60°F)
        val correctionFactor = (temperature - 60f) * 0.000082f
        val correctedOG = og + correctionFactor
        val correctedFG = fg + correctionFactor
        
        // Standard ABV formula from memory: (OG - FG) × 131.25
        return (correctedOG - correctedFG) * 131.25f
    }

    /**
     * Convert specific gravity to degrees Plato
     * Uses the formula from our Python implementation:
     * -463.37 + (668.72 * SG) - (205.35 * SG * SG)
     * @param gravity Specific gravity (e.g., 1.055)
     * @return Degrees Plato
     */
    fun gravityToPlato(gravity: Float): Float {
        return -463.37f + (668.72f * gravity) - (205.35f * gravity * gravity)
    }
}
