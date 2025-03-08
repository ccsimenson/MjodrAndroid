package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.viewmodels.AbvCalculatorViewModel
import java.text.DecimalFormat

/**
 * ABV Calculator screen with Viking theme
 * Implements the core ABV calculation functionality with temperature correction and Plato conversion
 */
@Composable
fun AbvCalculatorScreen(
    onNavigateBack: () -> Unit,
    viewModel: AbvCalculatorViewModel = viewModel()
) {
    val decimalFormat = DecimalFormat("#.##")
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Input Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = VikingColors.LightWood,
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
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.enter_measurements),
                    style = MaterialTheme.typography.titleLarge,
                    color = VikingColors.TextDark,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Original Gravity Input
                OutlinedTextField(
                    value = viewModel.originalGravity,
                    onValueChange = viewModel::updateOriginalGravity,
                    label = { Text(stringResource(R.string.original_gravity), color = VikingColors.TextDark) },
                    placeholder = { Text(stringResource(R.string.og_example), color = VikingColors.TextDark.copy(alpha = 0.6f)) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.TextDark,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.TextDark,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.TextDark,
                        unfocusedTextColor = VikingColors.TextDark
                    ),
                    isError = viewModel.originalGravityError,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                if (viewModel.originalGravityError && !viewModel.ogFgComparisonError) {
                    Text(
                        text = stringResource(R.string.error_invalid_gravity),
                        color = VikingColors.DeepRed,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, top = 4.dp)
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Final Gravity Input
                OutlinedTextField(
                    value = viewModel.finalGravity,
                    onValueChange = viewModel::updateFinalGravity,
                    label = { Text(stringResource(R.string.final_gravity), color = VikingColors.TextDark) },
                    placeholder = { Text(stringResource(R.string.fg_example), color = VikingColors.TextDark.copy(alpha = 0.6f)) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.TextDark,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.TextDark,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.TextDark,
                        unfocusedTextColor = VikingColors.TextDark
                    ),
                    isError = viewModel.finalGravityError,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                if (viewModel.finalGravityError && !viewModel.ogFgComparisonError) {
                    Text(
                        text = stringResource(R.string.error_invalid_gravity),
                        color = VikingColors.DeepRed,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, top = 4.dp)
                    )
                }
                
                // OG/FG comparison error
                if (viewModel.ogFgComparisonError) {
                    Text(
                        text = stringResource(R.string.error_og_less_than_fg),
                        color = VikingColors.DeepRed,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, top = 4.dp)
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Temperature Input (Optional)
                OutlinedTextField(
                    value = viewModel.temperature,
                    onValueChange = viewModel::updateTemperature,
                    label = { Text(stringResource(R.string.temperature), color = VikingColors.TextDark) },
                    placeholder = { Text(stringResource(R.string.temp_example), color = VikingColors.TextDark.copy(alpha = 0.6f)) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = VikingColors.Gold,
                        unfocusedBorderColor = VikingColors.TextDark,
                        focusedLabelColor = VikingColors.Gold,
                        unfocusedLabelColor = VikingColors.TextDark,
                        cursorColor = VikingColors.Gold,
                        focusedTextColor = VikingColors.TextDark,
                        unfocusedTextColor = VikingColors.TextDark
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Calculate and Reset Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VikingButton(
                        text = stringResource(R.string.reset),
                        onClick = viewModel::reset,
                        modifier = Modifier.weight(1f)
                    )
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    VikingButton(
                        text = stringResource(R.string.calculate),
                        onClick = { viewModel.calculate() },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
        
        // Results Card (only shown when results are available)
        viewModel.abvResult?.let { abv ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = VikingColors.Gold.copy(alpha = 0.9f),
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
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.wisdom_reveals),
                        style = MaterialTheme.typography.titleLarge,
                        color = VikingColors.TextDark,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    // ABV Result
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                            .background(
                                color = VikingColors.DarkWood,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "${decimalFormat.format(abv)}%",
                                style = MaterialTheme.typography.headlineLarge,
                                color = VikingColors.Parchment,
                                fontWeight = FontWeight.Bold
                            )
                            
                            Text(
                                text = stringResource(R.string.alcohol_by_volume),
                                style = MaterialTheme.typography.bodyLarge,
                                color = VikingColors.Gold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Plato Conversions
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Original Gravity in Plato
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(R.string.original_gravity),
                                style = MaterialTheme.typography.bodyMedium,
                                color = VikingColors.TextDark
                            )
                            
                            Text(
                                text = "${decimalFormat.format(viewModel.platoOG)}°P",
                                style = MaterialTheme.typography.titleLarge,
                                color = VikingColors.TextDark,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        
                        // Final Gravity in Plato
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(R.string.final_gravity),
                                style = MaterialTheme.typography.bodyMedium,
                                color = VikingColors.TextDark
                            )
                            
                            Text(
                                text = "${decimalFormat.format(viewModel.platoFG)}°P",
                                style = MaterialTheme.typography.titleLarge,
                                color = VikingColors.TextDark,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.weight(1f))
    }
}
