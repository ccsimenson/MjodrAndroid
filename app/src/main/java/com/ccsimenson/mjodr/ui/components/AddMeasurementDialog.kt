package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ccsimenson.mjodr.ui.theme.VikingColors

/**
 * Dialog for adding a new gravity measurement to a mead batch
 * Styled with the Viking theme
 */
@Composable
fun AddMeasurementDialog(
    gravity: String,
    temperature: String,
    notes: String,
    onGravityChange: (String) -> Unit,
    onTemperatureChange: (String) -> Unit,
    onNotesChange: (String) -> Unit,
    onAddClick: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(8.dp),
            color = VikingColors.DarkWood
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Record New Measurement",
                    style = MaterialTheme.typography.headlineSmall,
                    color = VikingColors.Gold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Current Gravity
                OutlinedTextField(
                    value = gravity,
                    onValueChange = onGravityChange,
                    label = { Text("Current Gravity", color = VikingColors.Parchment) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Temperature
                OutlinedTextField(
                    value = temperature,
                    onValueChange = onTemperatureChange,
                    label = { Text("Temperature (°F, Optional)", color = VikingColors.Parchment) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Notes
                OutlinedTextField(
                    value = notes,
                    onValueChange = onNotesChange,
                    label = { Text("Tasting Notes", color = VikingColors.Parchment) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VikingButton(
                        text = "Cancel",
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f)
                    )
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    VikingButton(
                        text = "Record",
                        onClick = onAddClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}
