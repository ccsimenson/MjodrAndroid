package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ccsimenson.mjodr.ui.theme.VikingColors
import kotlin.math.round

@Composable
fun CalculatorScreen(
    onNavigateBack: () -> Unit
) {
    var originalGravity by remember { mutableStateOf("") }
    var finalGravity by remember { mutableStateOf("") }
    var temperature by remember { mutableStateOf("") }
    var abvResult by remember { mutableStateOf("") }
    var platoResult by remember { mutableStateOf("") }
    
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(VikingColors.DarkWood)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sacred Measurements",
                color = VikingColors.Parchment,
                fontSize = 28.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Input fields with Viking styling
            GravityInputField(
                label = "Original Gravity",
                value = originalGravity,
                onValueChange = { originalGravity = it }
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            GravityInputField(
                label = "Final Gravity",
                value = finalGravity,
                onValueChange = { finalGravity = it }
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            GravityInputField(
                label = "Temperature (°F)",
                value = temperature,
                onValueChange = { temperature = it }
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Calculate button with Viking styling
            Button(
                onClick = {
                    val og = originalGravity.toFloatOrNull() ?: 1.000f
                    val fg = finalGravity.toFloatOrNull() ?: 1.000f
                    val temp = temperature.toFloatOrNull() ?: 60f
                    
                    // Temperature correction (if not at 60°F)
                    val correctionFactor = (temp - 60f) * 0.000082f
                    val correctedOG = og + correctionFactor
                    val correctedFG = fg + correctionFactor
                    
                    // Calculate ABV using standard formula: (OG - FG) × 131.25
                    val abv = (correctedOG - correctedFG) * 131.25f
                    abvResult = "%.2f%%".format(abv)
                    
                    // Convert to Plato
                    val ogPlato = (-463.37f + (668.72f * og) - (205.35f * og * og)).round(1)
                    platoResult = "$ogPlato°P"
                },
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
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
                    text = "Calculate",
                    fontSize = 18.sp
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Results display with Viking styling
            if (abvResult.isNotEmpty()) {
                Text(
                    text = "Strength of the Mead",
                    color = VikingColors.Gold,
                    fontSize = 20.sp
                )
                Text(
                    text = abvResult,
                    color = VikingColors.Parchment,
                    fontSize = 32.sp,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Original Gravity in Plato",
                    color = VikingColors.Gold,
                    fontSize = 20.sp
                )
                Text(
                    text = platoResult,
                    color = VikingColors.Parchment,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Back button
            TextButton(
                onClick = onNavigateBack,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = VikingColors.Gold
                )
            ) {
                Text("Return to Mead Hall")
            }
        }
    }
}

@Composable
private fun GravityInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = VikingColors.Gold) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = VikingColors.ParchmentAlpha90,
            unfocusedContainerColor = VikingColors.ParchmentAlpha90,
            focusedTextColor = VikingColors.TextDark,
            unfocusedTextColor = VikingColors.TextDark
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
    )
}

private fun Float.round(decimals: Int): Float {
    var multiplier = 1.0f
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}
