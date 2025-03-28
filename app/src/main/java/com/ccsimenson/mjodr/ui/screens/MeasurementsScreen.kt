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
fun MeasurementsScreen(onNavigateBack: () -> Unit) {
    var gravity by remember { mutableStateOf("") }
    var temperature by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = gravity,
            onValueChange = { gravity = it },
            label = { Text("Gravity Reading") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = temperature,
            onValueChange = { temperature = it },
            label = { Text("Temperature (°F)") },
            modifier = Modifier.fillMaxWidth()
        )

        VikingButton(
            text = "Save Reading",
            onClick = { /* TODO: Implement saving */ }
        )

        Spacer(modifier = Modifier.weight(1f))

        VikingButton(
            text = stringResource(id = R.string.back_to_mead_hall),
            onClick = onNavigateBack
        )
    }
}