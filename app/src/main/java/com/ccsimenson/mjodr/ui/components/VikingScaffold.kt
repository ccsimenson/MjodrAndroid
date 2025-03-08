package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ccsimenson.mjodr.navigation.Screen
import com.ccsimenson.mjodr.ui.theme.VikingColors

/**
 * Scaffold with Viking theme
 * Provides consistent layout with top app bar and bottom navigation
 */
@Composable
fun VikingScaffold(
    navController: NavController,
    title: String,
    canNavigateBack: Boolean = false,
    showBottomBar: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    
    Scaffold(
        topBar = {
            VikingTopAppBar(
                title = title,
                canNavigateBack = canNavigateBack,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        },
        bottomBar = {
            if (showBottomBar) {
                VikingBottomNavigation(navController = navController)
            }
        },
        containerColor = VikingColors.DarkWood
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(VikingColors.DarkWood),
            color = VikingColors.DarkWood
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = innerPadding.calculateTopPadding(),
                        bottom = innerPadding.calculateBottomPadding(),
                        start = 8.dp,
                        end = 8.dp
                    )
            ) {
                content(innerPadding)
            }
        }
    }
}
