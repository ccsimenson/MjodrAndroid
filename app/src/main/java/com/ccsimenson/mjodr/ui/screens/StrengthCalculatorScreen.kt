package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.utils.AbvCalculator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StrengthCalculatorScreen(
    onNavigateBack: () -> Unit = {}
) {
    var originalGravity by remember { mutableStateOf("1.055") }  // Example OG value from memory
    var finalGravity by remember { mutableStateOf("1.015") }    // Example FG value from memory
    var abvResult by remember { mutableStateOf("") }
    var platoResult by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VikingColors.DarkWood  // Dark wood brown (#2C1810) background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title with Papyrus-style font
            Text(
                text = "Sacred Measurements",
                style = MaterialTheme.typography.displayLarge,
                color = VikingColors.Gold  // Soft gold (#DAA520) for accents
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Input fields with Viking styling
            Column(
                modifier = Modifier
                    .width(400.dp)  // Main window size from memory
                    .heightIn(max = 300.dp)  // Main window size from memory
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Original Gravity Input
                OutlinedTextField(
                    value = originalGravity,
                    onValueChange = { originalGravity = it },
                    label = { Text("Original Gravity", color = VikingColors.Parchment) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                // Final Gravity Input
                OutlinedTextField(
                    value = finalGravity,
                    onValueChange = { finalGravity = it },
                    label = { Text("Final Gravity", color = VikingColors.Parchment) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                // Calculate Button with Viking styling
                VikingButton(
                    text = "Calculate Strength",
                    onClick = {
                        try {
                            val og = originalGravity.toDouble()
                            val fg = finalGravity.toDouble()
                            
                            // Use exact Python implementation: (OG - FG) × 131.25
                            val abv = AbvCalculator.calculateAbv(og, fg)
                            val plato = AbvCalculator.gravityToPlato(og)
                            
                            // Example values (OG=1.055, FG=1.015) should yield 5.25% ABV
                            abvResult = "%.2f%%".format(abv)
                            platoResult = "%.1f°P".format(plato)
                        } catch (e: Exception) {
                            abvResult = "Invalid input"
                            platoResult = ""
                        }
                    }
                )

                // Results Display with Viking theme colors
                if (abvResult.isNotEmpty()) {
                    Text(
                        text = "ABV: $abvResult",
                        style = MaterialTheme.typography.titleLarge,
                        color = VikingColors.Gold  // Soft gold (#DAA520) for results
                    )
                }
                if (platoResult.isNotEmpty()) {
                    Text(
                        text = "Original Gravity in Plato: $platoResult",
                        style = MaterialTheme.typography.titleMedium,
                        color = VikingColors.Gold  // Soft gold (#DAA520) for results
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                // Back Button with Viking styling
                VikingButton(
                    text = "Return to Mead Hall",
                    onClick = onNavigateBack
                )
            }
        }
    }
}
