package com.ccsimenson.mjodr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
                onNavigateToMeadHall = { navController.navigate(Screen.MeadHall.route) },
                onNavigateToHelp = { navController.navigate(Screen.Help.route) }
            )
        }
        
        composable(Screen.StrengthCalculator.route) {
            // Will implement later
            StrengthCalculatorScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(Screen.Recipes.route) {
            // Will implement later
            RecipesScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(Screen.MeadHall.route) {
            // Will implement later
            MeadHallScreen(onNavigateBack = { navController.popBackStack() })
        }
        
        composable(Screen.Help.route) {
            // Will implement later
            HelpScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}
