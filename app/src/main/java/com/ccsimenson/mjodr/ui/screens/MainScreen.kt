package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ccsimenson.mjodr.ui.theme.VikingColors

@Composable
fun MainScreen(
    onNavigateToCalculator: () -> Unit,
    onNavigateToRecipes: () -> Unit,
    onNavigateToBatchManagement: () -> Unit,
    onNavigateToHelp: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(VikingColors.DarkWood)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Mjöðr Calculator",
                color = VikingColors.Parchment,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Main feature buttons with Viking styling
            FeatureButton(
                text = "Sacred Measurements",
                onClick = onNavigateToCalculator
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            FeatureButton(
                text = "Ancient Recipes",
                onClick = onNavigateToRecipes
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            FeatureButton(
                text = "Mead Hall",
                onClick = onNavigateToBatchManagement
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            FeatureButton(
                text = "Wisdom of Odin",
                onClick = onNavigateToHelp
            )
        }
    }
}

@Composable
private fun FeatureButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(300.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = VikingColors.LightWood,
            contentColor = VikingColors.TextDark
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 5.dp
        )
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
