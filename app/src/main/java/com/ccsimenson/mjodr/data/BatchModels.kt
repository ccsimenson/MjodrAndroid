package com.ccsimenson.mjodr.data

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.UUID

/**
 * Status of a mead batch
 */
enum class BatchStatus {
    PLANNING,
    FERMENTING,
    AGING,
    BOTTLED,
    COMPLETED,
    ARCHIVED
}

/**
 * Data model for a mead batch
 */
data class MeadBatch(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val recipe: String = "",
    val originalGravity: Double,
    val targetFinalGravity: Double? = null,
    val notes: String = "",
    val startDate: LocalDate,
    val targetEndDate: LocalDate? = null,
    val status: BatchStatus = BatchStatus.FERMENTING,
    val measurements: List<GravityMeasurement> = emptyList()
) {
    /**
     * Current gravity (most recent measurement)
     */
    val currentGravity: Double?
        get() = measurements.maxByOrNull { it.date }?.gravity
    
    /**
     * Current ABV calculation based on original gravity and current gravity
     */
    val currentAbv: Double
        get() {
            val currentGrav = currentGravity ?: return 0.0
            return calculateAbv(originalGravity, currentGrav)
        }
    
    /**
     * Potential ABV calculation based on original gravity and target final gravity
     */
    val potentialAbv: Double
        get() {
            val targetFg = targetFinalGravity ?: return 0.0
            return calculateAbv(originalGravity, targetFg)
        }
    
    /**
     * Number of days the batch has been fermenting
     */
    val daysInFermentation: Long
        get() = ChronoUnit.DAYS.between(startDate, LocalDate.now())
    
    /**
     * Formatted start date string
     */
    val formattedStartDate: String
        get() = startDate.format(DateTimeFormatter.ofPattern("MMM d, yyyy"))
    
    /**
     * Formatted target end date string
     */
    val formattedTargetEndDate: String
        get() = targetEndDate?.format(DateTimeFormatter.ofPattern("MMM d, yyyy")) ?: "Not set"
    
    /**
     * Calculate ABV from original gravity and final gravity
     */
    private fun calculateAbv(og: Double, fg: Double): Double {
        return (og - fg) * 131.25
    }
}

/**
 * Data model for a gravity measurement
 */
data class GravityMeasurement(
    val gravity: Double,
    val temperature: Double? = null,
    val notes: String = "",
    val date: LocalDate = LocalDate.now()
) {
    /**
     * Formatted date string
     */
    val formattedDate: String
        get() = date.format(DateTimeFormatter.ofPattern("MMM d, yyyy"))
    
    /**
     * Temperature-corrected gravity
     * Formula: SG_corrected = SG + ((calibration_temp - measured_temp) * 0.00065)
     * Assumes calibration temperature of 60°F
     */
    val correctedGravity: Double
        get() {
            val temp = temperature ?: return gravity
            return gravity + ((60 - temp) * 0.00065)
        }
}
