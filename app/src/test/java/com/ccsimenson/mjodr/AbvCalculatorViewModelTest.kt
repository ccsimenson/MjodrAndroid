package com.ccsimenson.mjodr

import com.ccsimenson.mjodr.ui.viewmodels.AbvCalculatorViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class AbvCalculatorViewModelTest {
    
    private lateinit var viewModel: AbvCalculatorViewModel
    
    @Before
    fun setUp() {
        viewModel = AbvCalculatorViewModel()
    }
    
    @Test
    fun `calculate ABV with valid inputs`() {
        // Given
        viewModel.updateOriginalGravity("1.055")
        viewModel.updateFinalGravity("1.015")
        
        // When
        viewModel.calculate()
        
        // Then
        assertEquals(5.25, viewModel.abvResult, 0.01)
        assertEquals(13.53, viewModel.platoOG, 0.01)
        assertEquals(3.84, viewModel.platoFG, 0.01)
    }
    
    @Test
    fun `calculate ABV with invalid original gravity`() {
        // Given
        viewModel.updateOriginalGravity("invalid")
        viewModel.updateFinalGravity("1.015")
        
        // When
        viewModel.calculate()
        
        // Then
        assertNull(viewModel.abvResult)
        assertEquals(true, viewModel.originalGravityError)
    }
    
    @Test
    fun `calculate ABV with invalid final gravity`() {
        // Given
        viewModel.updateOriginalGravity("1.055")
        viewModel.updateFinalGravity("invalid")
        
        // When
        viewModel.calculate()
        
        // Then
        assertNull(viewModel.abvResult)
        assertEquals(true, viewModel.finalGravityError)
    }
    
    @Test
    fun `calculate ABV with OG less than FG`() {
        // Given
        viewModel.updateOriginalGravity("1.010")
        viewModel.updateFinalGravity("1.015")
        
        // When
        viewModel.calculate()
        
        // Then
        assertNull(viewModel.abvResult)
        assertEquals(true, viewModel.ogFgComparisonError)
    }
    
    @Test
    fun `reset clears all values`() {
        // Given
        viewModel.updateOriginalGravity("1.055")
        viewModel.updateFinalGravity("1.015")
        viewModel.updateTemperature("68")
        viewModel.calculate()
        
        // When
        viewModel.reset()
        
        // Then
        assertEquals("", viewModel.originalGravity)
        assertEquals("", viewModel.finalGravity)
        assertEquals("", viewModel.temperature)
        assertNull(viewModel.abvResult)
        assertEquals(false, viewModel.originalGravityError)
        assertEquals(false, viewModel.finalGravityError)
        assertEquals(false, viewModel.ogFgComparisonError)
    }
}
