package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.theme.VikingColors

@Composable
fun BatchDetailsScreen(onNavigateBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = VikingColors.LightWood)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Batch Status",
                    style = MaterialTheme.typography.headlineMedium,
                    color = VikingColors.Gold
                )
                StatusProgressIndicator()
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth().weight(1f),
            colors = CardDefaults.cardColors(containerColor = VikingColors.LightWood)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Readings History",
                    style = MaterialTheme.typography.headlineMedium,
                    color = VikingColors.Gold
                )
                ReadingsHistoryList()
            }
        }

        VikingButton(
            text = stringResource(id = R.string.back_to_mead_hall),
            onClick = onNavigateBack
        )
    }
}