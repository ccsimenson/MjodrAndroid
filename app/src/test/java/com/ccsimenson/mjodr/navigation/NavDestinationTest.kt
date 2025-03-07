package com.ccsimenson.mjodr.navigation

import org.junit.Assert.assertEquals
import org.junit.Test

class NavDestinationTest {
    
    @Test
    fun `verify nav destinations have correct routes`() {
        // Test all navigation destinations have the expected route values
        assertEquals("main", NavDestination.Main.route)
        assertEquals("calculator", NavDestination.Calculator.route)
        assertEquals("recipes", NavDestination.Recipes.route)
        assertEquals("mead_hall", NavDestination.MeadHall.route)
    }
    
    @Test
    fun `verify nav destinations have correct titles`() {
        // Test all navigation destinations have the expected title resource IDs
        assertEquals(com.ccsimenson.mjodr.R.string.app_name, NavDestination.Main.titleRes)
        assertEquals(com.ccsimenson.mjodr.R.string.sacred_measurements, NavDestination.Calculator.titleRes)
        assertEquals(com.ccsimenson.mjodr.R.string.ancient_recipes, NavDestination.Recipes.titleRes)
        assertEquals(com.ccsimenson.mjodr.R.string.mead_hall, NavDestination.MeadHall.titleRes)
    }
    
    @Test
    fun `verify nav destinations have correct icon resources`() {
        // Test all navigation destinations have the expected icon resource IDs
        assertEquals(com.ccsimenson.mjodr.R.drawable.ic_home, NavDestination.Main.iconRes)
        assertEquals(com.ccsimenson.mjodr.R.drawable.ic_calculator, NavDestination.Calculator.iconRes)
        assertEquals(com.ccsimenson.mjodr.R.drawable.ic_recipe, NavDestination.Recipes.iconRes)
        assertEquals(com.ccsimenson.mjodr.R.drawable.ic_mead, NavDestination.MeadHall.iconRes)
    }
}
