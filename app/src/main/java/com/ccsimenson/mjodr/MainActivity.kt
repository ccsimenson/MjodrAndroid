package com.ccsimenson.mjodr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ccsimenson.mjodr.navigation.NavGraph
import com.ccsimenson.mjodr.ui.theme.MjodrTheme
import com.ccsimenson.mjodr.ui.theme.VikingButton
import com.ccsimenson.mjodr.ui.theme.VikingColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MjodrTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = VikingColors.DarkWood
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    onNavigateToCalculator: () -> Unit = {},
    onNavigateToRecipes: () -> Unit = {},
    onNavigateToMeadHall: () -> Unit = {},
    onNavigateToHelp: () -> Unit = {}
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

        // Subtitle
        Text(
            text = "Viking Mead Making Assistant",
            style = MaterialTheme.typography.titleLarge,
            color = VikingColors.Gold
        )

        // Navigation Buttons
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(top = 16.dp)
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
                onClick = onNavigateToMeadHall
            )

            VikingButton(
                text = stringResource(R.string.runes_of_knowledge),
                onClick = onNavigateToHelp
            )
        }
    }
}
