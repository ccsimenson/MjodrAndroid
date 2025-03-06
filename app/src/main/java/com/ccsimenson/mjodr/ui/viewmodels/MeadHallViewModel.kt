package com.ccsimenson.mjodr.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ccsimenson.mjodr.data.BatchRepository
import com.ccsimenson.mjodr.data.BatchStatus
import com.ccsimenson.mjodr.data.GravityMeasurement
import com.ccsimenson.mjodr.data.MeadBatch
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate

/**
 * ViewModel for the Mead Hall screen
 * Manages batch tracking functionality
 */
class MeadHallViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = BatchRepository(application)
    
    val batches: StateFlow<List<MeadBatch>> = repository.batches
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    
    // Selected batch for details view
    var selectedBatchId by mutableStateOf<String?>(null)
        private set
    
    // New batch form state
    var newBatchName by mutableStateOf("")
        private set
    
    var newBatchRecipe by mutableStateOf("")
        private set
    
    var newBatchOG by mutableStateOf("")
        private set
    
    var newBatchTargetFG by mutableStateOf("")
        private set
    
    var newBatchNotes by mutableStateOf("")
        private set
    
    var showAddBatchDialog by mutableStateOf(false)
        private set
    
    var showAddMeasurementDialog by mutableStateOf(false)
        private set
    
    // New measurement form state
    var newMeasurementGravity by mutableStateOf("")
        private set
    
    var newMeasurementTemperature by mutableStateOf("")
        private set
    
    var newMeasurementNotes by mutableStateOf("")
        private set
    
    /**
     * Select a batch to view details
     */
    fun selectBatch(id: String?) {
        selectedBatchId = id
    }
    
    /**
     * Show the add batch dialog
     */
    fun showAddBatchDialog() {
        resetNewBatchForm()
        showAddBatchDialog = true
    }
    
    /**
     * Hide the add batch dialog
     */
    fun hideAddBatchDialog() {
        showAddBatchDialog = false
    }
    
    /**
     * Show the add measurement dialog
     */
    fun showAddMeasurementDialog() {
        resetNewMeasurementForm()
        showAddMeasurementDialog = true
    }
    
    /**
     * Hide the add measurement dialog
     */
    fun hideAddMeasurementDialog() {
        showAddMeasurementDialog = false
    }
    
    /**
     * Reset the new batch form
     */
    private fun resetNewBatchForm() {
        newBatchName = ""
        newBatchRecipe = ""
        newBatchOG = ""
        newBatchTargetFG = ""
        newBatchNotes = ""
    }
    
    /**
     * Reset the new measurement form
     */
    private fun resetNewMeasurementForm() {
        newMeasurementGravity = ""
        newMeasurementTemperature = ""
        newMeasurementNotes = ""
    }
    
    /**
     * Update new batch name
     */
    fun updateNewBatchName(name: String) {
        newBatchName = name
    }
    
    /**
     * Update new batch recipe
     */
    fun updateNewBatchRecipe(recipe: String) {
        newBatchRecipe = recipe
    }
    
    /**
     * Update new batch original gravity
     */
    fun updateNewBatchOG(og: String) {
        newBatchOG = og
    }
    
    /**
     * Update new batch target final gravity
     */
    fun updateNewBatchTargetFG(fg: String) {
        newBatchTargetFG = fg
    }
    
    /**
     * Update new batch notes
     */
    fun updateNewBatchNotes(notes: String) {
        newBatchNotes = notes
    }
    
    /**
     * Update new measurement gravity
     */
    fun updateNewMeasurementGravity(gravity: String) {
        newMeasurementGravity = gravity
    }
    
    /**
     * Update new measurement temperature
     */
    fun updateNewMeasurementTemperature(temp: String) {
        newMeasurementTemperature = temp
    }
    
    /**
     * Update new measurement notes
     */
    fun updateNewMeasurementNotes(notes: String) {
        newMeasurementNotes = notes
    }
    
    /**
     * Add a new batch
     */
    fun addBatch() {
        val og = newBatchOG.toDoubleOrNull() ?: return
        val targetFg = newBatchTargetFG.toDoubleOrNull()
        
        val batch = MeadBatch(
            name = newBatchName,
            recipe = newBatchRecipe,
            originalGravity = og,
            targetFinalGravity = targetFg,
            notes = newBatchNotes,
            startDate = LocalDate.now(),
            status = BatchStatus.FERMENTING
        )
        
        viewModelScope.launch {
            repository.addBatch(batch)
            hideAddBatchDialog()
        }
    }
    
    /**
     * Add a new measurement to the selected batch
     */
    fun addMeasurement() {
        val batchId = selectedBatchId ?: return
        val gravity = newMeasurementGravity.toDoubleOrNull() ?: return
        val temperature = newMeasurementTemperature.toDoubleOrNull()
        
        val measurement = GravityMeasurement(
            gravity = gravity,
            temperature = temperature,
            notes = newMeasurementNotes,
            date = LocalDate.now()
        )
        
        viewModelScope.launch {
            repository.addMeasurement(batchId, measurement)
            hideAddMeasurementDialog()
        }
    }
    
    /**
     * Delete a batch
     */
    fun deleteBatch(id: String) {
        viewModelScope.launch {
            repository.deleteBatch(id)
            if (selectedBatchId == id) {
                selectedBatchId = null
            }
        }
    }
    
    /**
     * Update batch status
     */
    fun updateBatchStatus(id: String, status: BatchStatus) {
        val batch = repository.getBatch(id) ?: return
        val updatedBatch = batch.copy(status = status)
        
        viewModelScope.launch {
            repository.updateBatch(updatedBatch)
        }
    }
    
    /**
     * Get the selected batch
     */
    fun getSelectedBatch(): MeadBatch? {
        val id = selectedBatchId ?: return null
        return repository.getBatch(id)
    }
}
