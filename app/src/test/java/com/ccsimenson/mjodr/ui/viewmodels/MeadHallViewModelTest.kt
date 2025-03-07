package com.ccsimenson.mjodr.ui.viewmodels

import com.ccsimenson.mjodr.data.Batch
import com.ccsimenson.mjodr.data.BatchMeasurement
import com.ccsimenson.mjodr.data.BatchStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime

@OptIn(ExperimentalCoroutinesApi::class)
class MeadHallViewModelTest {
    
    private lateinit var viewModel: MeadHallViewModel
    private val testDispatcher = StandardTestDispatcher()
    
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = MeadHallViewModel()
    }
    
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    
    @Test
    fun `addBatch should add a new batch to the list`() = runTest {
        // Given
        viewModel.updateNewBatchName("Traditional Mead")
        viewModel.updateNewBatchRecipe("Honey, water, yeast")
        viewModel.updateNewBatchOG("1.090")
        viewModel.updateNewBatchTargetFG("1.010")
        viewModel.updateNewBatchNotes("First Viking batch")
        
        // When
        viewModel.addBatch()
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        val batches = viewModel.batches.first()
        assertEquals(1, batches.size)
        assertEquals("Traditional Mead", batches[0].name)
        assertEquals("Honey, water, yeast", batches[0].recipe)
        assertEquals("1.090", batches[0].originalGravity)
        assertEquals("1.010", batches[0].targetFinalGravity)
        assertEquals("First Viking batch", batches[0].notes)
        assertEquals(BatchStatus.FERMENTING, batches[0].status)
        assertFalse(viewModel.showAddBatchDialog)
    }
    
    @Test
    fun `addMeasurement should add a new measurement to selected batch`() = runTest {
        // Given - Add a batch first
        viewModel.updateNewBatchName("Traditional Mead")
        viewModel.updateNewBatchOG("1.090")
        viewModel.addBatch()
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Select the batch
        val batches = viewModel.batches.first()
        viewModel.selectBatch(batches[0].id)
        
        // Prepare measurement data
        viewModel.updateNewMeasurementGravity("1.050")
        viewModel.updateNewMeasurementTemperature("68")
        viewModel.updateNewMeasurementNotes("Fermentation active")
        
        // When
        viewModel.addMeasurement()
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        val updatedBatches = viewModel.batches.first()
        val selectedBatch = viewModel.getSelectedBatch()
        
        assertNotNull(selectedBatch)
        assertEquals(1, selectedBatch!!.measurements.size)
        assertEquals("1.050", selectedBatch.measurements[0].gravity)
        assertEquals("68", selectedBatch.measurements[0].temperature)
        assertEquals("Fermentation active", selectedBatch.measurements[0].notes)
        assertFalse(viewModel.showAddMeasurementDialog)
    }
    
    @Test
    fun `updateBatchStatus should change the status of a batch`() = runTest {
        // Given - Add a batch first
        viewModel.updateNewBatchName("Traditional Mead")
        viewModel.addBatch()
        testDispatcher.scheduler.advanceUntilIdle()
        
        val batches = viewModel.batches.first()
        val batchId = batches[0].id
        
        // When
        viewModel.updateBatchStatus(batchId, BatchStatus.COMPLETED)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        val updatedBatches = viewModel.batches.first()
        assertEquals(BatchStatus.COMPLETED, updatedBatches[0].status)
    }
    
    @Test
    fun `deleteBatch should remove a batch from the list`() = runTest {
        // Given - Add a batch first
        viewModel.updateNewBatchName("Traditional Mead")
        viewModel.addBatch()
        testDispatcher.scheduler.advanceUntilIdle()
        
        val batches = viewModel.batches.first()
        val batchId = batches[0].id
        
        // When
        viewModel.deleteBatch(batchId)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        val updatedBatches = viewModel.batches.first()
        assertTrue(updatedBatches.isEmpty())
        assertNull(viewModel.getSelectedBatch())
    }
    
    @Test
    fun `selectBatch should update the selected batch ID`() = runTest {
        // Given - Add a batch first
        viewModel.updateNewBatchName("Traditional Mead")
        viewModel.addBatch()
        testDispatcher.scheduler.advanceUntilIdle()
        
        val batches = viewModel.batches.first()
        val batchId = batches[0].id
        
        // When
        viewModel.selectBatch(batchId)
        
        // Then
        val selectedBatch = viewModel.getSelectedBatch()
        assertNotNull(selectedBatch)
        assertEquals(batchId, selectedBatch!!.id)
        
        // When selecting null
        viewModel.selectBatch(null)
        
        // Then
        assertNull(viewModel.getSelectedBatch())
    }
    
    @Test
    fun `dialog visibility functions should update dialog state`() {
        // Test showAddBatchDialog
        viewModel.showAddBatchDialog()
        assertTrue(viewModel.showAddBatchDialog)
        
        viewModel.hideAddBatchDialog()
        assertFalse(viewModel.showAddBatchDialog)
        
        // Test showAddMeasurementDialog
        viewModel.showAddMeasurementDialog()
        assertTrue(viewModel.showAddMeasurementDialog)
        
        viewModel.hideAddMeasurementDialog()
        assertFalse(viewModel.showAddMeasurementDialog)
    }
}
