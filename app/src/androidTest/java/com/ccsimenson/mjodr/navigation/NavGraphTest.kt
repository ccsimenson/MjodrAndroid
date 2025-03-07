package com.ccsimenson.mjodr.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ccsimenson.mjodr.ui.theme.MjodrTheme
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavGraphTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    
    private lateinit var navController: TestNavHostController
    
    @Before
    fun setupNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            
            MjodrTheme {
                NavGraph(navController = navController)
            }
        }
    }
    
    @Test
    fun navHost_startsAtMainScreen() {
        // Verify that the start destination is the Main screen
        assertEquals(NavDestination.Main.route, navController.currentBackStackEntry?.destination?.route)
    }
    
    @Test
    fun navHost_navigatesToCalculatorScreen() {
        // Navigate to Calculator screen using bottom navigation
        composeTestRule.onNodeWithContentDescription("Calculator").performClick()
        
        // Verify that we navigated to the Calculator screen
        assertEquals(NavDestination.Calculator.route, navController.currentBackStackEntry?.destination?.route)
    }
    
    @Test
    fun navHost_navigatesToRecipesScreen() {
        // Navigate to Recipes screen using bottom navigation
        composeTestRule.onNodeWithContentDescription("Recipes").performClick()
        
        // Verify that we navigated to the Recipes screen
        assertEquals(NavDestination.Recipes.route, navController.currentBackStackEntry?.destination?.route)
    }
    
    @Test
    fun navHost_navigatesToMeadHallScreen() {
        // Navigate to Mead Hall screen using bottom navigation
        composeTestRule.onNodeWithContentDescription("Mead Hall").performClick()
        
        // Verify that we navigated to the Mead Hall screen
        assertEquals(NavDestination.MeadHall.route, navController.currentBackStackEntry?.destination?.route)
    }
    
    @Test
    fun navHost_navigatesBackToMainFromCalculator() {
        // Navigate to Calculator screen
        composeTestRule.onNodeWithContentDescription("Calculator").performClick()
        
        // Navigate back to Main screen using bottom navigation
        composeTestRule.onNodeWithContentDescription("Home").performClick()
        
        // Verify that we navigated back to the Main screen
        assertEquals(NavDestination.Main.route, navController.currentBackStackEntry?.destination?.route)
    }
    
    @Test
    fun navHost_navigatesDirectlyBetweenFeatureScreens() {
        // Navigate to Calculator screen
        composeTestRule.onNodeWithContentDescription("Calculator").performClick()
        
        // Navigate directly to Recipes screen without going back to Main
        composeTestRule.onNodeWithContentDescription("Recipes").performClick()
        
        // Verify that we navigated to the Recipes screen
        assertEquals(NavDestination.Recipes.route, navController.currentBackStackEntry?.destination?.route)
        
        // Navigate directly to Mead Hall screen
        composeTestRule.onNodeWithContentDescription("Mead Hall").performClick()
        
        // Verify that we navigated to the Mead Hall screen
        assertEquals(NavDestination.MeadHall.route, navController.currentBackStackEntry?.destination?.route)
    }
}
