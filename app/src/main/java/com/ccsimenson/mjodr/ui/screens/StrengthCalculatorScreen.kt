package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.theme.VikingButton
import com.ccsimenson.mjodr.utils.AbvCalculator

@Composable
fun StrengthCalculatorScreen(
    onNavigateBack: () -> Unit
) {
    var originalGravity by remember { mutableStateOf(stringResource(R.string.og_example)) }
    var finalGravity by remember { mutableStateOf(stringResource(R.string.fg_example)) }
    var temperature by remember { mutableStateOf(stringResource(R.string.temp_example)) }
    var abvResult by remember { mutableStateOf<Float?>(null) }
    var platoResult by remember { mutableStateOf<Float?>(null) }
    
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
                text = stringResource(R.string.sacred_measurements),
                style = MaterialTheme.typography.headlineLarge,
                color = VikingColors.Gold
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Input fields with Viking styling
            GravityInputField(
                label = stringResource(R.string.original_gravity),
                value = originalGravity,
                onValueChange = { originalGravity = it }
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            GravityInputField(
                label = stringResource(R.string.final_gravity),
                value = finalGravity,
                onValueChange = { finalGravity = it }
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            GravityInputField(
                label = stringResource(R.string.temperature),
                value = temperature,
                onValueChange = { temperature = it }
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Calculate button with Viking styling (10px padding from memory)
            VikingButton(
                text = stringResource(R.string.calculate),
                onClick = {
                    val og = originalGravity.toFloatOrNull() ?: 1.055f  // Default to example value
                    val fg = finalGravity.toFloatOrNull() ?: 1.015f     // Default to example value
                    val temp = temperature.toFloatOrNull() ?: 60f       // Default to room temp
                    
                    abvResult = AbvCalculator.calculateAbv(og, fg, temp)
                    platoResult = AbvCalculator.gravityToPlato(og)
                }
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Results display with Viking styling
            abvResult?.let { abv ->
                Text(
                    text = stringResource(R.string.abv_result, abv),
                    style = MaterialTheme.typography.displayMedium,
                    color = VikingColors.Parchment,
                    modifier = Modifier.padding(8.dp)
                )
                
                platoResult?.let { plato ->
                    Text(
                        text = stringResource(R.string.plato_result, plato),
                        style = MaterialTheme.typography.headlineMedium,
                        color = VikingColors.Parchment,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Back button with Viking styling
            VikingButton(
                text = stringResource(R.string.back),
                onClick = onNavigateBack,
                modifier = Modifier.padding(bottom = 16.dp)
            )
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
            unfocusedTextColor = VikingColors.TextDark,
            focusedBorderColor = VikingColors.Gold,
            unfocusedBorderColor = VikingColors.LightWood
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
    )
}
