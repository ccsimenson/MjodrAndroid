package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ccsimenson.mjodr.ui.theme.VikingColors
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Dialog for adding a new mead batch
 * Styled with the Viking theme
 */
@Composable
fun AddBatchDialog(
    name: String,
    recipe: String,
    originalGravity: String,
    targetFinalGravity: String,
    notes: String,
    startDate: LocalDate = LocalDate.now(),
    onNameChange: (String) -> Unit,
    onRecipeChange: (String) -> Unit,
    onOriginalGravityChange: (String) -> Unit,
    onTargetFinalGravityChange: (String) -> Unit,
    onNotesChange: (String) -> Unit,
    onStartDateChange: (LocalDate) -> Unit = {},
    onAddClick: () -> Unit,
    onDismiss: () -> Unit
) {
    val dateFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy")
    
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
                    text = "Begin a New Mead Journey",
                    style = MaterialTheme.typography.headlineSmall,
                    color = VikingColors.Gold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Batch name
                OutlinedTextField(
                    value = name,
                    onValueChange = onNameChange,
                    label = { Text("Batch Name", color = VikingColors.Parchment) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    )
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Recipe
                OutlinedTextField(
                    value = recipe,
                    onValueChange = onRecipeChange,
                    label = { Text("Recipe", color = VikingColors.Parchment) },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3,
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    )
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Original Gravity
                OutlinedTextField(
                    value = originalGravity,
                    onValueChange = onOriginalGravityChange,
                    label = { Text("Original Gravity", color = VikingColors.Parchment) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    )
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Target Final Gravity
                OutlinedTextField(
                    value = targetFinalGravity,
                    onValueChange = onTargetFinalGravityChange,
                    label = { Text("Target Final Gravity", color = VikingColors.Parchment) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    )
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Start Date (read-only field)
                OutlinedTextField(
                    value = startDate.format(dateFormatter),
                    onValueChange = { },
                    label = { Text("Start Date", color = VikingColors.Parchment) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    readOnly = true,
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    )
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Notes
                OutlinedTextField(
                    value = notes,
                    onValueChange = onNotesChange,
                    label = { Text("Notes", color = VikingColors.Parchment) },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 5,
                    colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.Parchment,
                        unfocusedTextColor = VikingColors.Parchment
                    )
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Action buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                ) {
                    TextButton(
                        onClick = onDismiss,
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = VikingColors.Parchment
                        )
                    ) {
                        Text("Cancel")
                    }
                    
                    Button(
                        onClick = onAddClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = VikingColors.Gold,
                            contentColor = VikingColors.DarkWood
                        )
                    ) {
                        Text("Add Batch")
                    }
                }
            }
        }
    }
}
