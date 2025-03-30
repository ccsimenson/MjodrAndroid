package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth()
                )

                // Final Gravity Input
                OutlinedTextField(
                    value = finalGravity,
                    onValueChange = { finalGravity = it },
                    label = { Text("Final Gravity", color = VikingColors.Parchment) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth()
                )

                // Calculate Button
                VikingButton(
                    text = "Calculate Strength",
                    onClick = {
                        try {
                            val og = originalGravity.toDouble()
                            val fg = finalGravity.toDouble()
                            val abv = AbvCalculator.calculateAbv(og, fg)
                            val plato = AbvCalculator.gravityToPlato(og)
                            abvResult = "%.2f%%".format(abv)
                            platoResult = "%.1f°P".format(plato)
                        } catch (e: Exception) {
                            abvResult = "Invalid input"
                            platoResult = "Invalid input"
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Results display
            if (abvResult.isNotEmpty()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Alcohol By Volume",
                        style = MaterialTheme.typography.titleLarge,
                        color = VikingColors.Gold
                    )
                    Text(
                        text = abvResult,
                        style = MaterialTheme.typography.displayMedium,
                        color = VikingColors.Parchment
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text(
                        text = "Plato",
                        style = MaterialTheme.typography.titleLarge,
                        color = VikingColors.Gold
                    )
                    Text(
                        text = platoResult,
                        style = MaterialTheme.typography.displayMedium,
                        color = VikingColors.Parchment
                    )
                }
            }
        }
    }
}
