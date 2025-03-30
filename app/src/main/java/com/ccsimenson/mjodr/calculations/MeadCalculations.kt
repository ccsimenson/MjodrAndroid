package com.ccsimenson.mjodr.calculations

import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Utility class for mead-related calculations.
 * Provides methods for gravity corrections, ABV calculations, and unit conversions.
 */
object MeadCalculations {
    /**
     * Correct specific gravity reading for temperature differences
     * @param gravity The measured specific gravity
     * @param measuredTemp The temperature at measurement time (Fahrenheit)
     * @param calibrationTemp The calibration temperature of the hydrometer (default 60°F)
     * @return Temperature-corrected specific gravity
     */
    fun correctGravityForTemperature(
        gravity: Double,
        measuredTemp: Double,
        calibrationTemp: Double = 60.0
    ): Double {
        val correction = (measuredTemp - calibrationTemp) * 0.00000225 * gravity
        return ((gravity + correction) * 1000).roundToInt() / 1000.0
    }

    /**
     * Calculate ABV using the standard formula
     * @param originalGravity The original gravity reading
     * @param finalGravity The final gravity reading
     * @return Alcohol by volume percentage
     */
    fun calculateABVStandard(originalGravity: Double, finalGravity: Double): Double {
        val abv = (originalGravity - finalGravity) * 131.25
        return (abv * 100).roundToInt() / 100.0
    }

    /**
     * Calculate ABV using a more accurate formula for high-alcohol beverages
     * @param originalGravity The original gravity reading
     * @param finalGravity The final gravity reading
     * @return Alcohol by volume percentage
     */
    fun calculateABVAdvanced(originalGravity: Double, finalGravity: Double): Double {
        val abv = (76.08 * (originalGravity - finalGravity) / (1.775 - originalGravity)) * (finalGravity / 0.794)
        return (abv * 100).roundToInt() / 100.0
    }

    /**
     * Convert specific gravity to degrees Plato
     * @param gravity The specific gravity value
     * @return Degrees Plato
     */
    fun gravityToPlato(gravity: Double): Double {
        val plato = (-1 * 616.868) + (1111.14 * gravity) - 
                    (630.272 * gravity.pow(2)) + (135.997 * gravity.pow(3))
        return (plato * 100).roundToInt() / 100.0
    }
}
