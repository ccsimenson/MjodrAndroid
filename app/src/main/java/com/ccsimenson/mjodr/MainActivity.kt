package com.ccsimenson.mjodr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ccsimenson.mjodr.navigation.NavGraph
import com.ccsimenson.mjodr.navigation.Screen
import com.ccsimenson.mjodr.ui.theme.MjodrTheme
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.components.VikingScaffold
import com.ccsimenson.mjodr.ui.screens.*
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MjodrTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = VikingColors.DarkWood
                ) {
                    var showSplash by remember { mutableStateOf(true) }
                    
                    if (showSplash) {
                        SplashScreen()
                        LaunchedEffect(key1 = true) {
                            delay(2000) // Show splash for 2 seconds
                            showSplash = false
                        }
                    } else {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Home.route
                        ) {
                            composable(Screen.Home.route) {
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
                                        },
                                        onNavigateToBrewingHistory = {
                                            navController.navigate(Screen.BrewingHistory.route)
                                        }
                                    )
                                }
                            }
                            
                            composable(Screen.AbvCalculator.route) {
                                VikingScaffold(
                                    navController = navController,
                                    title = stringResource(id = R.string.sacred_measurements),
                                    canNavigateBack = true,
                                    showBottomBar = true
                                ) {
                                    AbvCalculatorScreen(
                                        onNavigateBack = { navController.popBackStack() }
                                    )
                                }
                            }
                            
                            composable(Screen.Recipes.route) {
                                VikingScaffold(
                                    navController = navController,
                                    title = stringResource(id = R.string.ancient_recipes),
                                    canNavigateBack = true,
                                    showBottomBar = true
                                ) {
                                    RecipesScreen(
                                        onNavigateBack = { navController.popBackStack() }
                                    )
                                }
                            }
                            
                            composable(Screen.MeadHall.route) {
                                VikingScaffold(
                                    navController = navController,
                                    title = stringResource(id = R.string.mead_hall),
                                    canNavigateBack = true,
                                    showBottomBar = true
                                ) {
                                    MeadHallScreen(
                                        onNavigateBack = { navController.popBackStack() }
                                    )
                                }
                            }
                            
                            composable(Screen.Help.route) {
                                VikingScaffold(
                                    navController = navController,
                                    title = stringResource(id = R.string.wisdom_of_odin),
                                    canNavigateBack = true,
                                    showBottomBar = true
                                ) {
                                    TemporaryScreen(
                                        title = stringResource(id = R.string.wisdom_of_odin),
                                        onNavigateBack = { navController.popBackStack() },
                                        onNavigateToBrewingHistory = { 
                                            navController.navigate(Screen.BrewingHistory.route)
                                        }
                                    )
                                }
                            }
                            
                            composable(Screen.BrewingHistory.route) {
                                VikingScaffold(
                                    navController = navController,
                                    title = stringResource(id = R.string.viking_brewing_title),
                                    canNavigateBack = true,
                                    showBottomBar = true
                                ) {
                                    VikingBrewingHistoryScreen(
                                        onNavigateBack = { navController.popBackStack() }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    onNavigateToCalculator: () -> Unit = {},
    onNavigateToRecipes: () -> Unit = {},
    onNavigateToBatchManagement: () -> Unit = {},
    onNavigateToHelp: () -> Unit = {},
    onNavigateToBrewingHistory: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displayLarge,
            color = VikingColors.Gold
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Main feature buttons with Viking styling
        Column(
            modifier = Modifier
                .width(400.dp)  // Main window size from memory
                .heightIn(max = 300.dp)  // Main window size from memory
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            VikingButton(
                text = stringResource(R.string.sacred_measurements),
                onClick = onNavigateToCalculator
            )

            VikingButton(
                text = stringResource(R.string.ancient_recipes),
                onClick = onNavigateToRecipes
            )

            VikingButton(
                text = stringResource(R.string.mead_hall),
                onClick = onNavigateToBatchManagement
            )

            VikingButton(
                text = stringResource(R.string.wisdom_of_odin),
                onClick = onNavigateToHelp
            )
            
            VikingButton(
                text = stringResource(R.string.viking_brewing_title),
                onClick = onNavigateToBrewingHistory
            )
        }
    }
}

@Composable
fun TemporaryScreen(
    title: String,
    onNavigateBack: () -> Unit,
    onNavigateToBrewingHistory: () -> Unit
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
            text = stringResource(id = R.string.viking_brewing_title),
            onClick = onNavigateToBrewingHistory
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        VikingButton(
            text = "Return to Mead Hall",
            onClick = onNavigateBack
        )
    }
}
