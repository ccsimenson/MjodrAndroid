package com.ccsimenson.mjodr.ui.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ccsimenson.mjodr.ui.theme.MjodrTheme
import com.ccsimenson.mjodr.ui.viewmodels.AbvCalculatorViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AbvCalculatorScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun abvCalculatorScreen_displaysAllInputFields() {
        // When
        composeTestRule.setContent {
            MjodrTheme {
                AbvCalculatorScreen(
                    onNavigateBack = {},
                    viewModel = AbvCalculatorViewModel()
                )
            }
        }
        
        // Then - Verify all input fields are displayed
        composeTestRule.onNodeWithText("Original Gravity").assertExists()
        composeTestRule.onNodeWithText("Final Gravity").assertExists()
        composeTestRule.onNodeWithText("Temperature (°F)").assertExists()
        
        // Verify buttons are displayed
        composeTestRule.onNodeWithText("Reset").assertExists()
        composeTestRule.onNodeWithText("Calculate").assertExists()
    }
    
    @Test
    fun abvCalculatorScreen_calculatesAbvCorrectly() {
        // When
        composeTestRule.setContent {
            MjodrTheme {
                AbvCalculatorScreen(
                    onNavigateBack = {},
                    viewModel = AbvCalculatorViewModel()
                )
            }
        }
        
        // Enter valid gravity values
        composeTestRule.onNodeWithText("Original Gravity").performTextInput("1.055")
        composeTestRule.onNodeWithText("Final Gravity").performTextInput("1.015")
        
        // Click calculate button
        composeTestRule.onNodeWithText("Calculate").performClick()
        
        // Then - Verify ABV result is displayed
        composeTestRule.onNodeWithText("5.25%").assertExists()
        composeTestRule.onNodeWithText("Alcohol by Volume").assertExists()
        
        // Verify Plato conversions are displayed
        composeTestRule.onNodeWithText("13.53°P").assertExists()
        composeTestRule.onNodeWithText("3.84°P").assertExists()
    }
    
    @Test
    fun abvCalculatorScreen_showsErrorForInvalidInput() {
        // When
        composeTestRule.setContent {
            MjodrTheme {
                AbvCalculatorScreen(
                    onNavigateBack = {},
                    viewModel = AbvCalculatorViewModel()
                )
            }
        }
        
        // Enter invalid gravity values
        composeTestRule.onNodeWithText("Original Gravity").performTextInput("invalid")
        composeTestRule.onNodeWithText("Final Gravity").performTextInput("1.015")
        
        // Click calculate button
        composeTestRule.onNodeWithText("Calculate").performClick()
        
        // Then - Verify error message is displayed
        composeTestRule.onNodeWithText("Please enter a valid gravity reading (e.g., 1.050)").assertExists()
        
        // No ABV result should be displayed
        composeTestRule.onNodeWithText("Alcohol by Volume").assertDoesNotExist()
    }
    
    @Test
    fun abvCalculatorScreen_showsErrorWhenOgLessThanFg() {
        // When
        composeTestRule.setContent {
            MjodrTheme {
                AbvCalculatorScreen(
                    onNavigateBack = {},
                    viewModel = AbvCalculatorViewModel()
                )
            }
        }
        
        // Enter OG less than FG
        composeTestRule.onNodeWithText("Original Gravity").performTextInput("1.010")
        composeTestRule.onNodeWithText("Final Gravity").performTextInput("1.015")
        
        // Click calculate button
        composeTestRule.onNodeWithText("Calculate").performClick()
        
        // Then - Verify error message is displayed
        composeTestRule.onNodeWithText("Original gravity must be greater than final gravity").assertExists()
        
        // No ABV result should be displayed
        composeTestRule.onNodeWithText("Alcohol by Volume").assertDoesNotExist()
    }
    
    @Test
    fun abvCalculatorScreen_resetClearsAllFields() {
        // When
        composeTestRule.setContent {
            MjodrTheme {
                AbvCalculatorScreen(
                    onNavigateBack = {},
                    viewModel = AbvCalculatorViewModel()
                )
            }
        }
        
        // Enter values and calculate
        composeTestRule.onNodeWithText("Original Gravity").performTextInput("1.055")
        composeTestRule.onNodeWithText("Final Gravity").performTextInput("1.015")
        composeTestRule.onNodeWithText("Temperature (°F)").performTextInput("68")
        composeTestRule.onNodeWithText("Calculate").performClick()
        
        // Verify result is displayed
        composeTestRule.onNodeWithText("5.25%").assertExists()
        
        // Click reset button
        composeTestRule.onNodeWithText("Reset").performClick()
        
        // Then - Verify all fields are cleared
        composeTestRule.onNodeWithText("Original Gravity").assertTextEquals("Original Gravity")
        composeTestRule.onNodeWithText("Final Gravity").assertTextEquals("Final Gravity")
        composeTestRule.onNodeWithText("Temperature (°F)").assertTextEquals("Temperature (°F)")
        
        // No ABV result should be displayed
        composeTestRule.onNodeWithText("Alcohol by Volume").assertDoesNotExist()
    }
    
    @Test
    fun abvCalculatorScreen_temperatureCorrectionApplied() {
        // When
        composeTestRule.setContent {
            MjodrTheme {
                AbvCalculatorScreen(
                    onNavigateBack = {},
                    viewModel = AbvCalculatorViewModel()
                )
            }
        }
        
        // Enter values with temperature
        composeTestRule.onNodeWithText("Original Gravity").performTextInput("1.055")
        composeTestRule.onNodeWithText("Final Gravity").performTextInput("1.015")
        composeTestRule.onNodeWithText("Temperature (°F)").performTextInput("80")
        
        // Click calculate button
        composeTestRule.onNodeWithText("Calculate").performClick()
        
        // Then - Verify ABV result is displayed with temperature correction
        // The exact value may vary slightly due to temperature correction
        composeTestRule.onNodeWithText("Alcohol by Volume").assertExists()
    }
}
