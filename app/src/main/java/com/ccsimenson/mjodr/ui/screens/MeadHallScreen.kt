package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.ui.components.*
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.viewmodels.MeadHallViewModel

/**
 * Mead Hall screen for batch management
 * Styled with the Viking theme
 */
@Composable
fun MeadHallScreen(
    onNavigateBack: () -> Unit,
    viewModel: MeadHallViewModel = viewModel()
) {
    val batches by viewModel.batches.collectAsState()
    val selectedBatch = viewModel.getSelectedBatch()
    
    // Show add batch dialog if needed
    if (viewModel.showAddBatchDialog) {
        AddBatchDialog(
            name = viewModel.newBatchName,
            recipe = viewModel.newBatchRecipe,
            originalGravity = viewModel.newBatchOG,
            targetFinalGravity = viewModel.newBatchTargetFG,
            notes = viewModel.newBatchNotes,
            onNameChange = viewModel::updateNewBatchName,
            onRecipeChange = viewModel::updateNewBatchRecipe,
            onOriginalGravityChange = viewModel::updateNewBatchOG,
            onTargetFinalGravityChange = viewModel::updateNewBatchTargetFG,
            onNotesChange = viewModel::updateNewBatchNotes,
            onAddClick = viewModel::addBatch,
            onDismiss = viewModel::hideAddBatchDialog
        )
    }
    
    // Show add measurement dialog if needed
    if (viewModel.showAddMeasurementDialog) {
        AddMeasurementDialog(
            gravity = viewModel.newMeasurementGravity,
            temperature = viewModel.newMeasurementTemperature,
            notes = viewModel.newMeasurementNotes,
            onGravityChange = viewModel::updateNewMeasurementGravity,
            onTemperatureChange = viewModel::updateNewMeasurementTemperature,
            onNotesChange = viewModel::updateNewMeasurementNotes,
            onAddClick = viewModel::addMeasurement,
            onDismiss = viewModel::hideAddMeasurementDialog
        )
    }
    
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VikingColors.DarkWood
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Text(
                text = stringResource(R.string.mead_hall),
                style = MaterialTheme.typography.headlineLarge,
                color = VikingColors.Gold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // Add batch button
            VikingButton(
                text = "Begin New Mead Journey",
                onClick = viewModel::showAddBatchDialog,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Content area - either batch list or batch details
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                if (selectedBatch != null) {
                    // Batch details view
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        BatchDetailsCard(
                            batch = selectedBatch,
                            onAddMeasurementClick = viewModel::showAddMeasurementDialog,
                            onStatusChange = { status ->
                                viewModel.updateBatchStatus(selectedBatch.id, status)
                            },
                            onDeleteClick = {
                                viewModel.deleteBatch(selectedBatch.id)
                            }
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        VikingButton(
                            text = "Back to Batch List",
                            onClick = { viewModel.selectBatch(null) },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                } else {
                    // Batch list view
                    if (batches.isEmpty()) {
                        // Empty state
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "No mead batches yet. Begin your first mead journey!",
                                style = MaterialTheme.typography.bodyLarge,
                                color = VikingColors.Parchment,
                                textAlign = TextAlign.Center
                            )
                        }
                    } else {
                        // Batch list
                        LazyColumn {
                            items(batches) { batch ->
                                BatchListItem(
                                    batch = batch,
                                    onClick = { viewModel.selectBatch(batch.id) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
