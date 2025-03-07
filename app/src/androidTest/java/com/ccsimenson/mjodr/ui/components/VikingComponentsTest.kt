package com.ccsimenson.mjodr.ui.components

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.navigation.NavDestination
import com.ccsimenson.mjodr.ui.theme.MjodrTheme
import com.ccsimenson.mjodr.ui.theme.VikingColors
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VikingComponentsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun vikingButton_displaysCorrectText() {
        // Given
        val buttonText = "Test Button"
        
        // When
        composeTestRule.setContent {
            MjodrTheme {
                VikingButton(
                    text = buttonText,
                    onClick = {}
                )
            }
        }
        
        // Then
        composeTestRule.onNodeWithText(buttonText).assertExists()
        composeTestRule.onNodeWithText(buttonText).assertHasClickAction()
    }
    
    @Test
    fun vikingTopAppBar_displaysCorrectTitle() {
        // Given
        val title = "Test Title"
        
        // When
        composeTestRule.setContent {
            MjodrTheme {
                VikingTopAppBar(
                    title = title,
                    canNavigateBack = true,
                    onNavigateBack = {}
                )
            }
        }
        
        // Then
        composeTestRule.onNodeWithText(title).assertExists()
        composeTestRule.onNodeWithContentDescription("Back").assertExists()
        composeTestRule.onNodeWithContentDescription("Back").assertHasClickAction()
    }
    
    @Test
    fun vikingTopAppBar_hidesBackButtonWhenNotNeeded() {
        // Given
        val title = "Test Title"
        
        // When
        composeTestRule.setContent {
            MjodrTheme {
                VikingTopAppBar(
                    title = title,
                    canNavigateBack = false,
                    onNavigateBack = {}
                )
            }
        }
        
        // Then
        composeTestRule.onNodeWithText(title).assertExists()
        composeTestRule.onNodeWithContentDescription("Back").assertDoesNotExist()
    }
    
    @Test
    fun vikingBottomNavigation_displaysAllItems() {
        // Given
        val destinations = listOf(
            NavDestination.Main,
            NavDestination.Calculator,
            NavDestination.Recipes,
            NavDestination.MeadHall
        )
        
        // When
        composeTestRule.setContent {
            MjodrTheme {
                VikingBottomNavigation(
                    destinations = destinations,
                    onNavigateToDestination = {},
                    currentDestination = NavDestination.Main
                )
            }
        }
        
        // Then
        // Check that all navigation items exist
        composeTestRule.onNodeWithContentDescription("Home").assertExists()
        composeTestRule.onNodeWithContentDescription("Calculator").assertExists()
        composeTestRule.onNodeWithContentDescription("Recipes").assertExists()
        composeTestRule.onNodeWithContentDescription("Mead Hall").assertExists()
        
        // Current destination should be selected
        composeTestRule.onNodeWithContentDescription("Home").assertIsSelected()
    }
    
    @Test
    fun vikingScaffold_integratesTopAndBottomNavigation() {
        // Given
        val title = "Test Title"
        val destinations = listOf(
            NavDestination.Main,
            NavDestination.Calculator
        )
        
        // When
        composeTestRule.setContent {
            MjodrTheme {
                VikingScaffold(
                    title = title,
                    canNavigateBack = true,
                    onNavigateBack = {},
                    destinations = destinations,
                    onNavigateToDestination = {},
                    currentDestination = NavDestination.Main,
                    content = {}
                )
            }
        }
        
        // Then
        composeTestRule.onNodeWithText(title).assertExists()
        composeTestRule.onNodeWithContentDescription("Back").assertExists()
        composeTestRule.onNodeWithContentDescription("Home").assertExists()
        composeTestRule.onNodeWithContentDescription("Calculator").assertExists()
    }
}
