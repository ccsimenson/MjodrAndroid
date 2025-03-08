package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.theme.VikingColors

@Composable
fun RecipesScreen(onNavigateBack: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VikingColors.DarkWood
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.ancient_recipes),
                style = MaterialTheme.typography.headlineLarge,
                color = VikingColors.Gold
            )

            Spacer(modifier = Modifier.weight(1f))
            
            Text(
                text = "YouTube recipe search coming soon...",
                style = MaterialTheme.typography.bodyLarge,
                color = VikingColors.Parchment
            )

            Spacer(modifier = Modifier.weight(1f))

            VikingButton(
                text = stringResource(R.string.back),
                onClick = onNavigateBack
            )
        }
    }
}

@Composable
fun MeadHallScreen(onNavigateBack: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VikingColors.DarkWood
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.mead_hall),
                style = MaterialTheme.typography.headlineLarge,
                color = VikingColors.Gold
            )

            Spacer(modifier = Modifier.weight(1f))
            
            Text(
                text = "Batch management coming soon...",
                style = MaterialTheme.typography.bodyLarge,
                color = VikingColors.Parchment
            )

            Spacer(modifier = Modifier.weight(1f))

            VikingButton(
                text = stringResource(R.string.back),
                onClick = onNavigateBack
            )
        }
    }
}

@Composable
fun HelpScreen(onNavigateBack: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VikingColors.DarkWood
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.wisdom_of_odin),
                style = MaterialTheme.typography.headlineLarge,
                color = VikingColors.Gold
            )

            Spacer(modifier = Modifier.weight(1f))
            
            Text(
                text = "Help and guidance coming soon...",
                style = MaterialTheme.typography.bodyLarge,
                color = VikingColors.Parchment
            )

            Spacer(modifier = Modifier.weight(1f))

            VikingButton(
                text = stringResource(R.string.back),
                onClick = onNavigateBack
            )
        }
    }
}
