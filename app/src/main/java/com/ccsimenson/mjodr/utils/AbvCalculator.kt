package com.ccsimenson.mjodr.utils

/**
 * Viking-themed ABV calculator utility class
 * Implements the standard ABV formula: (OG - FG) × 131.25
 * Example usage: OG=1.055, FG=1.015 yielding 5.25% ABV
 */
object AbvCalculator {
    /**
     * Calculate ABV (Alcohol By Volume) from original and final gravity
     * Matches Python implementation exactly
     * @param og Original gravity (e.g., 1.055)
     * @param fg Final gravity (e.g., 1.015)
     * @return ABV percentage
     */
    fun calculateAbv(og: Double, fg: Double): Double {
        // Standard ABV formula from Python implementation: (OG - FG) × 131.25
        return (og - fg) * 131.25
    }

    /**
     * Convert specific gravity to degrees Plato
     * Uses the formula from our Python implementation:
     * -463.37 + (668.72 * SG) - (205.35 * SG * SG)
     * @param gravity Specific gravity (e.g., 1.055)
     * @return Degrees Plato
     */
    fun gravityToPlato(gravity: Double): Double {
        return -463.37 + (668.72 * gravity) - (205.35 * gravity * gravity)
    }
}
