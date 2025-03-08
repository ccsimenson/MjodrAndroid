package com.ccsimenson.mjodr.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ccsimenson.mjodr.utils.AbvCalculator

/**
 * ViewModel for the ABV Calculator screen
 * Manages state and calculations for the ABV calculator
 */
class AbvCalculatorViewModel : ViewModel() {
    
    // Input fields
    var originalGravity by mutableStateOf("")
        private set
    
    var finalGravity by mutableStateOf("")
        private set
    
    var temperature by mutableStateOf("")
        private set
    
    // Calculation results
    var abvResult by mutableStateOf<Double?>(null)
        private set
    
    var platoOG by mutableStateOf<Double?>(null)
        private set
    
    var platoFG by mutableStateOf<Double?>(null)
        private set
    
    // Temperature correction tracking
    var temperatureCorrectionApplied by mutableStateOf(false)
        private set
    
    var appliedTemperature by mutableStateOf("")
        private set
    
    // Error states
    var originalGravityError by mutableStateOf(false)
        private set
    
    var finalGravityError by mutableStateOf(false)
        private set
    
    var ogFgComparisonError by mutableStateOf(false)
        private set
    
    /**
     * Update original gravity input
     */
    fun updateOriginalGravity(value: String) {
        originalGravity = value
        originalGravityError = false
        ogFgComparisonError = false
    }
    
    /**
     * Update final gravity input
     */
    fun updateFinalGravity(value: String) {
        finalGravity = value
        finalGravityError = false
        ogFgComparisonError = false
    }
    
    /**
     * Update temperature input
     */
    fun updateTemperature(value: String) {
        temperature = value
    }
    
    /**
     * Calculate ABV and Plato values
     * @return true if calculation was successful, false otherwise
     */
    fun calculate(): Boolean {
        // Reset error states
        originalGravityError = false
        finalGravityError = false
        ogFgComparisonError = false
        temperatureCorrectionApplied = false
        appliedTemperature = ""
        
        // Parse input values
        val og = originalGravity.toDoubleOrNull()
        val fg = finalGravity.toDoubleOrNull()
        val temp = temperature.toDoubleOrNull()
        
        // Validate inputs
        if (og == null) {
            originalGravityError = true
            return false
        }
        
        if (fg == null) {
            finalGravityError = true
            return false
        }
        
        // Validate gravity values are in reasonable range
        if (og < 0.990 || og > 1.200) {
            originalGravityError = true
            return false
        }
        
        if (fg < 0.990 || fg > 1.200) {
            finalGravityError = true
            return false
        }
        
        // Ensure OG is greater than FG
        if (og < fg) {
            originalGravityError = true
            finalGravityError = true
            ogFgComparisonError = true
            return false
        }
        
        // Apply temperature correction if provided
        val correctedOG: Double
        val correctedFG: Double
        
        if (temp != null) {
            // Track that temperature correction was applied
            temperatureCorrectionApplied = true
            appliedTemperature = temperature
            
            correctedOG = applyTemperatureCorrection(og, temp)
            correctedFG = applyTemperatureCorrection(fg, temp)
        } else {
            correctedOG = og
            correctedFG = fg
        }
        
        // Calculate ABV
        abvResult = AbvCalculator.calculateAbv(correctedOG, correctedFG)
        
        // Calculate Plato values
        platoOG = AbvCalculator.gravityToPlato(correctedOG)
        platoFG = AbvCalculator.gravityToPlato(correctedFG)
        
        return true
    }
    
    /**
     * Reset all inputs and results
     */
    fun reset() {
        originalGravity = ""
        finalGravity = ""
        temperature = ""
        abvResult = null
        platoOG = null
        platoFG = null
        originalGravityError = false
        finalGravityError = false
        ogFgComparisonError = false
        temperatureCorrectionApplied = false
        appliedTemperature = ""
    }
    
    /**
     * Apply temperature correction to a gravity reading
     * Formula: SG_corrected = SG + ((calibration_temp - measured_temp) * 0.00065)
     * Assumes calibration temperature of 60°F
     */
    private fun applyTemperatureCorrection(gravity: Double, temp: Double): Double {
        // Standard calibration temperature is 60°F (15.6°C)
        val calibrationTemp = 60.0
        return gravity + ((calibrationTemp - temp) * 0.00065)
    }
}
