package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.data.BatchStatus
import com.ccsimenson.mjodr.data.GravityMeasurement
import com.ccsimenson.mjodr.data.MeadBatch
import com.ccsimenson.mjodr.ui.theme.VikingColors
import java.text.DecimalFormat

/**
 * A card component for displaying detailed information about a mead batch
 * Styled with the Viking theme
 */
@Composable
fun BatchDetailsCard(
    batch: MeadBatch,
    onAddMeasurementClick: () -> Unit,
    onStatusChange: (BatchStatus) -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val decimalFormat = DecimalFormat("#.###")
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = VikingColors.LightWood.copy(alpha = 0.9f),
            contentColor = VikingColors.TextDark
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Batch header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = batch.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = VikingColors.TextDark
                )
                
                StatusBadge(status = batch.status)
            }
            
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = VikingColors.DarkWood.copy(alpha = 0.3f)
            )
            
            // Batch details
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    DetailItem(label = "Started", value = batch.formattedStartDate)
                    DetailItem(label = "Days Fermenting", value = batch.daysInFermentation.toString())
                    DetailItem(
                        label = "Target End",
                        value = batch.formattedTargetEndDate
                    )
                }
                
                Column(modifier = Modifier.weight(1f)) {
                    DetailItem(
                        label = "Original Gravity",
                        value = decimalFormat.format(batch.originalGravity)
                    )
                    DetailItem(
                        label = "Current Gravity",
                        value = batch.currentGravity?.let { decimalFormat.format(it) } ?: "Not measured"
                    )
                    DetailItem(
                        label = "Current ABV",
                        value = "${decimalFormat.format(batch.currentAbv)}%"
                    )
                }
            }
            
            // Recipe
            if (batch.recipe.isNotBlank()) {
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "Recipe",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = VikingColors.TextDark
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = batch.recipe,
                    style = MaterialTheme.typography.bodyMedium,
                    color = VikingColors.TextDark
                )
            }
            
            // Notes
            if (batch.notes.isNotBlank()) {
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "Brewing Notes",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = VikingColors.TextDark
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = batch.notes,
                    style = MaterialTheme.typography.bodyMedium,
                    color = VikingColors.TextDark
                )
            }
            
            // Measurements
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Measurements",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = VikingColors.TextDark
                )
                
                VikingButton(
                    text = "Add Measurement",
                    onClick = onAddMeasurementClick,
                    modifier = Modifier.wrapContentWidth()
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            if (batch.measurements.isEmpty()) {
                Text(
                    text = "No measurements recorded yet",
                    style = MaterialTheme.typography.bodyMedium,
                    color = VikingColors.TextDark.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    items(batch.measurements.sortedByDescending { it.date }) { measurement ->
                        MeasurementItem(measurement = measurement)
                    }
                }
            }
            
            // Status change and delete buttons
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Status dropdown
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    StatusDropdown(
                        currentStatus = batch.status,
                        onStatusChange = onStatusChange
                    )
                }
                
                Spacer(modifier = Modifier.width(8.dp))
                
                // Delete button
                Button(
                    onClick = onDeleteClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = VikingColors.DeepRed,
                        contentColor = VikingColors.Parchment
                    ),
                    modifier = Modifier.wrapContentWidth()
                ) {
                    Text("Delete Batch")
                }
            }
        }
    }
}

/**
 * A component for displaying a detail item with label and value
 */
@Composable
fun DetailItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = VikingColors.TextDark.copy(alpha = 0.7f)
        )
        
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = VikingColors.TextDark
        )
    }
}

/**
 * A component for displaying a measurement item
 */
@Composable
fun MeasurementItem(
    measurement: GravityMeasurement,
    modifier: Modifier = Modifier
) {
    val decimalFormat = DecimalFormat("#.###")
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = VikingColors.DarkWood.copy(alpha = 0.1f),
            contentColor = VikingColors.TextDark
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = measurement.formattedDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = VikingColors.TextDark.copy(alpha = 0.7f)
                )
                
                if (measurement.notes.isNotBlank()) {
                    Text(
                        text = measurement.notes,
                        style = MaterialTheme.typography.bodySmall,
                        color = VikingColors.TextDark
                    )
                }
            }
            
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "SG: ${decimalFormat.format(measurement.gravity)}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = VikingColors.TextDark
                )
                
                if (measurement.temperature != null) {
                    Text(
                        text = "Temp: ${decimalFormat.format(measurement.temperature)}°F",
                        style = MaterialTheme.typography.bodySmall,
                        color = VikingColors.TextDark
                    )
                }
            }
        }
    }
}

/**
 * A dropdown for changing batch status
 */
@Composable
fun StatusDropdown(
    currentStatus: BatchStatus,
    onStatusChange: (BatchStatus) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded = false
    
    Box(
        modifier = modifier
            .wrapContentSize(Alignment.TopStart)
    ) {
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(
                containerColor = VikingColors.Gold,
                contentColor = VikingColors.TextDark
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Change Status: ${currentStatus.name}")
        }
        
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(VikingColors.LightWood)
                .width(200.dp)
        ) {
            BatchStatus.values().forEach { status ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = status.name,
                            color = VikingColors.TextDark
                        )
                    },
                    onClick = {
                        onStatusChange(status)
                        expanded = false
                    }
                )
            }
        }
    }
}
