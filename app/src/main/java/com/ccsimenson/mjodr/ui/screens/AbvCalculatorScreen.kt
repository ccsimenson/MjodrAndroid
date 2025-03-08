package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.theme.vikingFontFamily
import com.ccsimenson.mjodr.ui.viewmodels.AbvCalculatorViewModel
import java.text.DecimalFormat

/**
 * ABV Calculator Screen
 * Allows users to calculate ABV based on original and final gravity readings
 */
@Composable
fun AbvCalculatorScreen(
    onNavigateBack: () -> Unit,
    viewModel: AbvCalculatorViewModel = viewModel()
) {
    val scrollState = rememberScrollState()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = stringResource(id = R.string.enter_measurements),
            fontFamily = vikingFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = VikingColors.Gold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // Input fields
        GravityInputField(
            value = viewModel.originalGravity,
            onValueChange = { viewModel.updateOriginalGravity(it) },
            label = stringResource(id = R.string.original_gravity),
            placeholder = stringResource(id = R.string.og_example),
            isError = viewModel.originalGravityError
        )
        
        GravityInputField(
            value = viewModel.finalGravity,
            onValueChange = { viewModel.updateFinalGravity(it) },
            label = stringResource(id = R.string.final_gravity),
            placeholder = stringResource(id = R.string.fg_example),
            isError = viewModel.finalGravityError
        )
        
        TemperatureInputField(
            value = viewModel.temperature,
            onValueChange = { viewModel.updateTemperature(it) },
            label = stringResource(id = R.string.temperature),
            placeholder = stringResource(id = R.string.temp_example),
            isError = viewModel.temperatureError
        )
        
        // Display error message if any
        viewModel.errorMessage?.let { errorKey ->
            ErrorMessage(errorKey)
        }
        
        // Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            VikingButton(
                onClick = { viewModel.calculate() },
                text = stringResource(id = R.string.calculate),
                modifier = Modifier.weight(1f)
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            VikingButton(
                onClick = { viewModel.reset() },
                text = stringResource(id = R.string.reset),
                modifier = Modifier.weight(1f)
            )
        }
        
        // Results
        viewModel.abvResult?.let { abv ->
            ResultsCard(
                abv = abv,
                platoOG = viewModel.platoOG,
                platoFG = viewModel.platoFG,
                originalGravity = viewModel.originalGravity,
                finalGravity = viewModel.finalGravity,
                temperatureCorrectionApplied = viewModel.temperatureCorrectionApplied,
                appliedTemperature = viewModel.appliedTemperature
            )
        }
    }
}

/**
 * Input field for gravity values
 */
@Composable
fun GravityInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    isError: Boolean
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = VikingColors.Gold,
            unfocusedBorderColor = VikingColors.LightWood,
            errorBorderColor = VikingColors.Red,
            cursorColor = VikingColors.Gold,
            focusedTextColor = VikingColors.LightWood,
            unfocusedTextColor = VikingColors.LightWood,
            focusedPlaceholderColor = VikingColors.LightWood.copy(alpha = 0.6f),
            unfocusedPlaceholderColor = VikingColors.LightWood.copy(alpha = 0.6f),
            focusedLabelColor = VikingColors.Gold,
            unfocusedLabelColor = VikingColors.LightWood,
            errorLabelColor = VikingColors.Red
        )
    )
}

/**
 * Input field for temperature values
 */
@Composable
fun TemperatureInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    isError: Boolean
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            isError = isError,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VikingColors.Gold,
                unfocusedBorderColor = VikingColors.LightWood,
                errorBorderColor = VikingColors.Red,
                cursorColor = VikingColors.Gold,
                focusedTextColor = VikingColors.LightWood,
                unfocusedTextColor = VikingColors.LightWood,
                focusedPlaceholderColor = VikingColors.LightWood.copy(alpha = 0.6f),
                unfocusedPlaceholderColor = VikingColors.LightWood.copy(alpha = 0.6f),
                focusedLabelColor = VikingColors.Gold,
                unfocusedLabelColor = VikingColors.LightWood,
                errorLabelColor = VikingColors.Red
            )
        )
        
        // Helper text for temperature field
        Text(
            text = stringResource(id = R.string.temp_correction_info),
            color = VikingColors.LightWood.copy(alpha = 0.7f),
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 8.dp)
        )
    }
}

/**
 * Display Viking-themed error message
 */
@Composable
fun ErrorMessage(errorKey: String) {
    val errorResId = when (errorKey) {
        "error_invalid_gravity_viking" -> R.string.error_invalid_gravity_viking
        "error_og_less_than_fg_viking" -> R.string.error_og_less_than_fg_viking
        "error_gravity_range_viking" -> R.string.error_gravity_range_viking
        "error_temperature_range_viking" -> R.string.error_temperature_range_viking
        "error_empty_fields_viking" -> R.string.error_empty_fields_viking
        else -> R.string.error_invalid_gravity
    }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = VikingColors.Red.copy(alpha = 0.2f)
        )
    ) {
        Text(
            text = stringResource(id = errorResId),
            color = VikingColors.Red,
            fontFamily = vikingFontFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

/**
 * Card to display calculation results
 */
@Composable
fun ResultsCard(
    abv: Double,
    platoOG: Double?,
    platoFG: Double?,
    originalGravity: String,
    finalGravity: String,
    temperatureCorrectionApplied: Boolean,
    appliedTemperature: String
) {
    val decimalFormat = remember { DecimalFormat("#.##") }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = VikingColors.DarkWood
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.wisdom_reveals),
                fontFamily = vikingFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = VikingColors.Gold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // ABV result
            Text(
                text = stringResource(id = R.string.abv_result, "${decimalFormat.format(abv)}%"),
                fontFamily = vikingFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = VikingColors.LightWood,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // Plato Conversion Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = VikingColors.DarkWood.copy(alpha = 0.7f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.plato_conversion_title),
                        fontFamily = vikingFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = VikingColors.Gold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    
                    // Original gravity in both SG and Plato
                    platoOG?.let {
                        Text(
                            text = stringResource(
                                id = R.string.og_plato_result,
                                originalGravity,
                                decimalFormat.format(it)
                            ),
                            fontFamily = vikingFontFamily,
                            fontSize = 14.sp,
                            color = VikingColors.LightWood,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                    
                    // Final gravity in both SG and Plato
                    platoFG?.let {
                        Text(
                            text = stringResource(
                                id = R.string.fg_plato_result,
                                finalGravity,
                                decimalFormat.format(it)
                            ),
                            fontFamily = vikingFontFamily,
                            fontSize = 14.sp,
                            color = VikingColors.LightWood,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                    
                    // Informational text about Plato scale
                    Text(
                        text = stringResource(id = R.string.plato_conversion_info),
                        fontFamily = vikingFontFamily,
                        fontSize = 12.sp,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                        color = VikingColors.LightWood.copy(alpha = 0.7f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
            
            // Temperature correction indicator
            if (temperatureCorrectionApplied) {
                Divider(color = VikingColors.Gold.copy(alpha = 0.5f))
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = stringResource(id = R.string.temp_correction_applied),
                    fontFamily = vikingFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = VikingColors.Gold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                
                Text(
                    text = stringResource(id = R.string.temp_correction_details, appliedTemperature),
                    fontFamily = vikingFontFamily,
                    fontSize = 14.sp,
                    color = VikingColors.LightWood.copy(alpha = 0.8f)
                )
            }
        }
    }
}
