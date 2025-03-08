package com.ccsimenson.mjodr.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.components.VikingScaffold
import com.ccsimenson.mjodr.ui.screens.*
import com.ccsimenson.mjodr.ui.theme.VikingColors

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AbvCalculator : Screen("abv_calculator")
    object Recipes : Screen("recipes")
    object MeadHall : Screen("mead_hall")
    object Help : Screen("help")
    object BrewingHistory : Screen("brewing_history")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                    animationSpec = tween(300)
                )
            }
        ) {
            VikingScaffold(
                navController = navController,
                title = stringResource(id = R.string.app_name),
                canNavigateBack = false,
                showBottomBar = true
            ) {
                MainScreen(
                    onNavigateToCalculator = { 
                        navController.navigate(Screen.AbvCalculator.route) 
                    },
                    onNavigateToRecipes = { 
                        navController.navigate(Screen.Recipes.route) 
                    },
                    onNavigateToBatchManagement = { 
                        navController.navigate(Screen.MeadHall.route) 
                    },
                    onNavigateToHelp = { 
                        navController.navigate(Screen.Help.route) 
                    }
                )
            }
        }
        
        composable(
            route = Screen.AbvCalculator.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            }
        ) {
            VikingScaffold(
                navController = navController,
                title = stringResource(id = R.string.sacred_measurements),
                canNavigateBack = true,
                showBottomBar = true
            ) {
                AbvCalculatorScreen(onNavigateBack = { navController.popBackStack() })
            }
        }
        
        composable(
            route = Screen.Recipes.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            }
        ) {
            VikingScaffold(
                navController = navController,
                title = stringResource(id = R.string.ancient_recipes),
                canNavigateBack = true,
                showBottomBar = true
            ) {
                RecipesScreen(onNavigateBack = { navController.popBackStack() })
            }
        }
        
        composable(
            route = Screen.MeadHall.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            }
        ) {
            VikingScaffold(
                navController = navController,
                title = stringResource(id = R.string.mead_hall),
                canNavigateBack = true,
                showBottomBar = true
            ) {
                MeadHallScreen(onNavigateBack = { navController.popBackStack() })
            }
        }
        
        composable(
            route = Screen.Help.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            }
        ) {
            VikingScaffold(
                navController = navController,
                title = stringResource(id = R.string.wisdom_of_odin),
                canNavigateBack = true,
                showBottomBar = true
            ) {
                // Placeholder for HelpScreen
                // Will implement the Wisdom of Odin screen later
                TemporaryScreen(
                    title = stringResource(id = R.string.wisdom_of_odin),
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}

@Composable
fun TemporaryScreen(title: String, onNavigateBack: () -> Unit) {
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
            text = stringResource(R.string.back),
            onClick = onNavigateBack
        )
    }
}
