package com.ccsimenson.mjodr.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.calculations.MeadCalculations
import com.ccsimenson.mjodr.ui.theme.VikingColors

@Composable
fun StrengthCalculatorScreen(onNavigateBack: () -> Unit) {
    var originalGravity by remember { mutableStateOf("") }
    var finalGravity by remember { mutableStateOf("") }
    var temperature by remember { mutableStateOf("") }
    var showTempCorrection by remember { mutableStateOf(false) }
    var results by remember { mutableStateOf<CalculationResults?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VikingColors.DarkWood
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Sacred Measurements",
                style = MaterialTheme.typography.headlineMedium,
                color = VikingColors.Gold,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            OutlinedTextField(
                value = originalGravity,
                onValueChange = { originalGravity = it },
                label = { Text("Original Gravity", color = VikingColors.Gold) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = VikingColors.Gold,
                    cursorColor = VikingColors.Gold,
                    focusedBorderColor = VikingColors.Gold,
                    unfocusedBorderColor = VikingColors.LightWood
                )
            )

            OutlinedTextField(
                value = finalGravity,
                onValueChange = { finalGravity = it },
                label = { Text("Final Gravity", color = VikingColors.Gold) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = VikingColors.Gold,
                    cursorColor = VikingColors.Gold,
                    focusedBorderColor = VikingColors.Gold,
                    unfocusedBorderColor = VikingColors.LightWood
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Checkbox(
                    checked = showTempCorrection,
                    onCheckedChange = { showTempCorrection = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = VikingColors.Gold,
                        uncheckedColor = VikingColors.LightWood
                    )
                )
                Text(
                    text = "Temperature Correction",
                    color = VikingColors.Gold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            AnimatedVisibility(visible = showTempCorrection) {
                OutlinedTextField(
                    value = temperature,
                    onValueChange = { temperature = it },
                    label = { Text("Temperature (°F)", color = VikingColors.Gold) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = VikingColors.Gold,
                        cursorColor = VikingColors.Gold,
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood
                    )
                )
            }

            Button(
                onClick = {
                    val og = originalGravity.toDoubleOrNull()
                    val fg = finalGravity.toDoubleOrNull()
                    if (og != null && fg != null) {
                        val correctedOG = if (showTempCorrection && temperature.isNotEmpty()) {
                            MeadCalculations.correctGravityForTemperature(
                                og,
                                temperature.toDoubleOrNull() ?: 60.0
                            )
                        } else og

                        val correctedFG = if (showTempCorrection && temperature.isNotEmpty()) {
                            MeadCalculations.correctGravityForTemperature(
                                fg,
                                temperature.toDoubleOrNull() ?: 60.0
                            )
                        } else fg

                        results = CalculationResults(
                            standardABV = MeadCalculations.calculateABVStandard(correctedOG, correctedFG),
                            advancedABV = MeadCalculations.calculateABVAdvanced(correctedOG, correctedFG),
                            originalPlato = MeadCalculations.gravityToPlato(correctedOG),
                            finalPlato = MeadCalculations.gravityToPlato(correctedFG)
                        )
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = VikingColors.Gold,
                    contentColor = VikingColors.DarkWood
                ),
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text("Calculate Strength")
            }

            results?.let { r ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = VikingColors.LightWood.copy(alpha = 0.9f)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Standard ABV: ${r.standardABV}%",
                            color = VikingColors.DarkWood,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Advanced ABV: ${r.advancedABV}%",
                            color = VikingColors.DarkWood,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Divider(color = VikingColors.DarkWood, modifier = Modifier.padding(vertical = 8.dp))
                        Text(
                            text = "Original Gravity: ${r.originalPlato}°P",
                            color = VikingColors.DarkWood
                        )
                        Text(
                            text = "Final Gravity: ${r.finalPlato}°P",
                            color = VikingColors.DarkWood
                        )
                    }
                }
            }
        }
    }
}

data class CalculationResults(
    val standardABV: Double,
    val advancedABV: Double,
    val originalPlato: Double,
    val finalPlato: Double
)

@Composable
fun RecipesScreen(onNavigateBack: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VikingColors.DarkWood
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Ancient Recipes Coming Soon",
                style = MaterialTheme.typography.titleLarge,
                color = VikingColors.Gold
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mead Hall Coming Soon",
                style = MaterialTheme.typography.titleLarge,
                color = VikingColors.Gold
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Runes of Knowledge Coming Soon",
                style = MaterialTheme.typography.titleLarge,
                color = VikingColors.Gold
            )
        }
    }
}
