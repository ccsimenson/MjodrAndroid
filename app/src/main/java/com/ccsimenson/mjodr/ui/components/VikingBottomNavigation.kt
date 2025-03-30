package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.navigation.Screen
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.theme.vikingFontFamily

/**
 * Bottom navigation bar with Viking theme
 * Provides quick access to all main screens
 */
@Composable
fun VikingBottomNavigation(navController: NavController) {
    val items = listOf(
        NavigationItem(
            route = Screen.Home.route,
            titleResId = R.string.app_name,
            iconResId = R.drawable.ic_home
        ),
        NavigationItem(
            route = Screen.AbvCalculator.route,
            titleResId = R.string.sacred_measurements,
            iconResId = R.drawable.ic_calculator
        ),
        NavigationItem(
            route = Screen.Recipes.route,
            titleResId = R.string.ancient_recipes,
            iconResId = R.drawable.ic_recipe
        ),
        NavigationItem(
            route = Screen.MeadHall.route,
            titleResId = R.string.mead_hall,
            iconResId = R.drawable.ic_mead
        )
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .shadow(elevation = 12.dp),
        containerColor = VikingColors.DarkWood,
        contentColor = VikingColors.Gold
    ) {
        items.forEach { item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            
            NavigationBarItem(
                icon = { 
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = stringResource(id = item.titleResId),
                        modifier = Modifier.size(26.dp),
                        tint = if (selected) VikingColors.Gold else VikingColors.LightWood
                    )
                },
                label = { 
                    Text(
                        text = stringResource(id = item.titleResId),
                        fontSize = 12.sp,
                        fontFamily = vikingFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = if (selected) VikingColors.Gold else VikingColors.LightWood
                    )
                },
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = VikingColors.Gold,
                    selectedTextColor = VikingColors.Gold,
                    unselectedIconColor = VikingColors.LightWood,
                    unselectedTextColor = VikingColors.LightWood,
                    indicatorColor = VikingColors.DarkWood
                )
            )
        }
    }
}

/**
 * Data class for navigation items
 */
data class NavigationItem(
    val route: String,
    val titleResId: Int,
    val iconResId: Int
)
