package com.ccsimenson.mjodr.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.util.UUID

/**
 * Repository for managing mead batches with local storage
 */
class BatchRepository(context: Context) {
    
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        PREFS_NAME, Context.MODE_PRIVATE
    )
    
    private val gson: Gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, LocalDateAdapter())
        .create()
    
    private val _batches = MutableStateFlow<List<MeadBatch>>(emptyList())
    val batches: StateFlow<List<MeadBatch>> = _batches.asStateFlow()
    
    init {
        loadBatches()
    }
    
    /**
     * Load batches from SharedPreferences
     */
    private fun loadBatches() {
        val batchesJson = sharedPreferences.getString(KEY_BATCHES, null)
        if (batchesJson != null) {
            val type = object : TypeToken<List<MeadBatch>>() {}.type
            val loadedBatches = gson.fromJson<List<MeadBatch>>(batchesJson, type)
            _batches.value = loadedBatches
        }
    }
    
    /**
     * Save batches to SharedPreferences
     */
    private fun saveBatches() {
        val batchesJson = gson.toJson(_batches.value)
        sharedPreferences.edit().putString(KEY_BATCHES, batchesJson).apply()
    }
    
    /**
     * Add a new batch
     */
    fun addBatch(batch: MeadBatch) {
        val newBatch = batch.copy(id = UUID.randomUUID().toString())
        _batches.update { currentBatches ->
            currentBatches + newBatch
        }
        saveBatches()
    }
    
    /**
     * Update an existing batch
     */
    fun updateBatch(batch: MeadBatch) {
        _batches.update { currentBatches ->
            currentBatches.map { if (it.id == batch.id) batch else it }
        }
        saveBatches()
    }
    
    /**
     * Delete a batch
     */
    fun deleteBatch(batchId: String) {
        _batches.update { currentBatches ->
            currentBatches.filter { it.id != batchId }
        }
        saveBatches()
    }
    
    /**
     * Get a batch by ID
     */
    fun getBatch(batchId: String): MeadBatch? {
        return _batches.value.find { it.id == batchId }
    }
    
    /**
     * Add a measurement to a batch
     */
    fun addMeasurement(batchId: String, measurement: GravityMeasurement) {
        val batch = getBatch(batchId) ?: return
        val updatedMeasurements = batch.measurements + measurement
        val updatedBatch = batch.copy(measurements = updatedMeasurements)
        updateBatch(updatedBatch)
    }
    
    /**
     * Update batch status and trigger notifications if needed
     */
    fun updateBatchStatus(batchId: String, newStatus: BatchStatus) {
        val batch = getBatch(batchId) ?: return
        val updatedBatch = batch.copy(status = newStatus)
        updateBatch(updatedBatch)
        
        // Trigger notification if status change is significant
        when (newStatus) {
            BatchStatus.COMPLETED -> triggerNotification(
                "Batch ${batch.name} completed!",
                "Your mead is ready for bottling"
            )
            BatchStatus.FAILED -> triggerNotification(
                "Batch ${batch.name} failed",
                "Check your batch for potential issues"
            )
            else -> {}
        }
    }
    
    /**
     * Trigger a notification for batch milestones
     */
    private fun triggerNotification(title: String, message: String) {
        // Implementation would use Android's NotificationManager
        // Placeholder for now
    }
    
    /**
     * Get batch statistics
     */
    fun getBatchStatistics(batchId: String): BatchStatistics {
        val batch = getBatch(batchId) ?: return BatchStatistics()
        return BatchStatistics(
            totalMeasurements = batch.measurements.size,
            daysFermenting = batch.startDate.until(LocalDate.now()).days,
            abvTrend = calculateAbvTrend(batch),
            temperatureTrend = calculateTemperatureTrend(batch)
        )
    }
    
    private fun calculateAbvTrend(batch: MeadBatch): List<Double> {
        return batch.measurements.map { measurement ->
            batch.calculateAbv(batch.originalGravity, measurement.gravity)
        }
    }
    
    private fun calculateTemperatureTrend(batch: MeadBatch): List<Double> {
        return batch.measurements.mapNotNull { it.temperature }
    }
    
    companion object {
        private const val PREFS_NAME = "mead_batches"
        private const val KEY_BATCHES = "batches"
    }
}
