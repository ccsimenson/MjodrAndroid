package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
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
import android.app.DatePickerDialog
import androidx.compose.ui.platform.LocalContext

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
    val context = LocalContext.current
    
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
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        textColor = VikingColors.Parchment
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Recipe
                OutlinedTextField(
                    value = recipe,
                    onValueChange = onRecipeChange,
                    label = { Text("Recipe", color = VikingColors.Parchment) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        textColor = VikingColors.Parchment
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Start Date
                OutlinedTextField(
                    value = startDate.format(dateFormatter),
                    onValueChange = { },
                    label = { Text("Start Date", color = VikingColors.Parchment) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        textColor = VikingColors.Parchment
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { 
                            val datePicker = DatePickerDialog(
                                context,
                                { _, year, month, dayOfMonth ->
                                    onStartDateChange(LocalDate.of(year, month + 1, dayOfMonth))
                                },
                                startDate.year,
                                startDate.monthValue - 1,
                                startDate.dayOfMonth
                            )
                            datePicker.show()
                        },
                    readOnly = true,
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Original Gravity
                OutlinedTextField(
                    value = originalGravity,
                    onValueChange = onOriginalGravityChange,
                    label = { Text("Original Gravity", color = VikingColors.Parchment) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        textColor = VikingColors.Parchment
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Target Final Gravity
                OutlinedTextField(
                    value = targetFinalGravity,
                    onValueChange = onTargetFinalGravityChange,
                    label = { Text("Target Final Gravity (Optional)", color = VikingColors.Parchment) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        textColor = VikingColors.Parchment
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
                    label = { Text("Brewing Notes", color = VikingColors.Parchment) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.LightWood,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.LightWood,
                        cursorColor = VikingColors.Gold,
                        textColor = VikingColors.Parchment
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
                        text = "Begin Fermentation",
                        onClick = onAddClick,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}
