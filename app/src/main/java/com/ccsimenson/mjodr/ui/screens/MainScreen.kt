package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.theme.vikingFontFamily

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
            .background(VikingColors.DarkWood),
        color = VikingColors.DarkWood
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = VikingColors.Gold,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = vikingFontFamily,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Main feature buttons with Viking styling
            VikingButton(
                text = stringResource(id = R.string.sacred_measurements),
                onClick = { onNavigateToCalculator() },
                modifier = Modifier
                    .width(300.dp)
                    .height(60.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            VikingButton(
                text = stringResource(id = R.string.ancient_recipes),
                onClick = { onNavigateToRecipes() },
                modifier = Modifier
                    .width(300.dp)
                    .height(60.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            VikingButton(
                text = stringResource(id = R.string.mead_hall),
                onClick = { onNavigateToBatchManagement() },
                modifier = Modifier
                    .width(300.dp)
                    .height(60.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            VikingButton(
                text = stringResource(id = R.string.wisdom_of_odin),
                onClick = { onNavigateToHelp() },
                modifier = Modifier
                    .width(300.dp)
                    .height(60.dp)
            )
        }
    }
}
