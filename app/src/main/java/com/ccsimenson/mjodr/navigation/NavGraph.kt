package com.ccsimenson.mjodr.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.screens.*
import com.ccsimenson.mjodr.ui.theme.VikingColors

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object StrengthCalculator : Screen("strength_calculator")
    object Recipes : Screen("recipes")
    object MeadHall : Screen("mead_hall")
    object Help : Screen("help")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            MainScreen(
                onNavigateToCalculator = { navController.navigate(Screen.StrengthCalculator.route) },
                onNavigateToRecipes = { navController.navigate(Screen.Recipes.route) },
                onNavigateToBatchManagement = { navController.navigate(Screen.MeadHall.route) },
                onNavigateToHelp = { navController.navigate(Screen.Help.route) }
            )
        }
        
        composable(Screen.StrengthCalculator.route) {
            StrengthCalculatorScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(Screen.Recipes.route) {
            // Placeholder for RecipesScreen
            // Will implement the Ancient Recipes screen later
            TemporaryScreen(
                title = "Ancient Recipes",
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.MeadHall.route) {
            // Placeholder for MeadHallScreen
            // Will implement the Mead Hall screen later
            TemporaryScreen(
                title = "Mead Hall",
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.Help.route) {
            // Placeholder for HelpScreen
            // Will implement the Wisdom of Odin screen later
            TemporaryScreen(
                title = "Wisdom of Odin",
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun TemporaryScreen(title: String, onNavigateBack: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VikingColors.DarkWood
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.displayLarge,
                color = VikingColors.Gold
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            VikingButton(
                text = "Return to Mead Hall",
                onClick = onNavigateBack
            )
        }
    }
}
