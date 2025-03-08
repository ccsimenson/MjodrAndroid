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
        
    var temperatureError by mutableStateOf(false)
        private set
        
    var emptyFieldsError by mutableStateOf(false)
        private set
    
    // Error message states
    var errorMessage by mutableStateOf<String?>(null)
        private set
    
    /**
     * Update original gravity input
     */
    fun updateOriginalGravity(value: String) {
        originalGravity = value
        originalGravityError = false
        ogFgComparisonError = false
        emptyFieldsError = false
        errorMessage = null
    }
    
    /**
     * Update final gravity input
     */
    fun updateFinalGravity(value: String) {
        finalGravity = value
        finalGravityError = false
        ogFgComparisonError = false
        emptyFieldsError = false
        errorMessage = null
    }
    
    /**
     * Update temperature input
     */
    fun updateTemperature(value: String) {
        temperature = value
        temperatureError = false
        errorMessage = null
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
        temperatureError = false
        emptyFieldsError = false
        temperatureCorrectionApplied = false
        appliedTemperature = ""
        errorMessage = null
        
        // Check for empty required fields
        if (originalGravity.isBlank() || finalGravity.isBlank()) {
            originalGravityError = originalGravity.isBlank()
            finalGravityError = finalGravity.isBlank()
            emptyFieldsError = true
            errorMessage = "error_empty_fields_viking"
            return false
        }
        
        // Parse input values
        val og = originalGravity.toDoubleOrNull()
        val fg = finalGravity.toDoubleOrNull()
        val temp = temperature.toDoubleOrNull()
        
        // Validate inputs
        if (og == null) {
            originalGravityError = true
            errorMessage = "error_invalid_gravity_viking"
            return false
        }
        
        if (fg == null) {
            finalGravityError = true
            errorMessage = "error_invalid_gravity_viking"
            return false
        }
        
        // Validate gravity values are in reasonable range
        if (og < 0.990 || og > 1.200) {
            originalGravityError = true
            errorMessage = "error_gravity_range_viking"
            return false
        }
        
        if (fg < 0.990 || fg > 1.200) {
            finalGravityError = true
            errorMessage = "error_gravity_range_viking"
            return false
        }
        
        // Ensure OG is greater than FG
        if (og < fg) {
            originalGravityError = true
            finalGravityError = true
            ogFgComparisonError = true
            errorMessage = "error_og_less_than_fg_viking"
            return false
        }
        
        // Validate temperature if provided
        if (temp != null && (temp < 32.0 || temp > 212.0)) {
            temperatureError = true
            errorMessage = "error_temperature_range_viking"
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
        temperatureError = false
        emptyFieldsError = false
        temperatureCorrectionApplied = false
        appliedTemperature = ""
        errorMessage = null
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
