package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import com.ccsimenson.mjodr.data.RecipeDifficulty
import com.ccsimenson.mjodr.data.RecipeType
import com.ccsimenson.mjodr.ui.theme.VikingColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeFilters(
    selectedType: RecipeType?,
    selectedDifficulty: RecipeDifficulty?,
    showFavoritesOnly: Boolean,
    onTypeSelected: (RecipeType?) -> Unit,
    onDifficultySelected: (RecipeDifficulty?) -> Unit,
    onFavoritesToggled: () -> Unit,
    onClearFilters: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showTypeDropdown by remember { mutableStateOf(false) }
    var showDifficultyDropdown by remember { mutableStateOf(false) }
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(VikingColors.DarkWood.copy(alpha = 0.9f))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Filter header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.FilterAlt,
                contentDescription = null,
                tint = VikingColors.Gold
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            Text(
                text = "FILTER BY",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                ),
                color = VikingColors.Gold
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Clear filters button
            if (selectedType != null || selectedDifficulty != null || showFavoritesOnly) {
                IconButton(onClick = onClearFilters) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear filters",
                        tint = VikingColors.Gold
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Filter chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Type filter
            Box {
                FilterChip(
                    selected = selectedType != null,
                    onClick = { showTypeDropdown = true },
                    label = {
                        Text(
                            text = selectedType?.name?.lowercase()?.replaceFirstChar { it.uppercase() } ?: "Type",
                            color = if (selectedType != null) VikingColors.TextDark else VikingColors.TextLight
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = VikingColors.DarkWood,
                        selectedContainerColor = VikingColors.Gold
                    )
                )
                
                DropdownMenu(
                    expanded = showTypeDropdown,
                    onDismissRequest = { showTypeDropdown = false },
                    modifier = Modifier.background(VikingColors.LightWood)
                ) {
                    // Option to clear type filter
                    DropdownMenuItem(
                        text = { Text("All Types", color = VikingColors.TextDark) },
                        onClick = {
                            onTypeSelected(null)
                            showTypeDropdown = false
                        }
                    )
                    
                    // Add all recipe types
                    RecipeType.values().forEach { type ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = type.name.lowercase().replaceFirstChar { it.uppercase() },
                                    color = VikingColors.TextDark
                                )
                            },
                            onClick = {
                                onTypeSelected(type)
                                showTypeDropdown = false
                            }
                        )
                    }
                }
            }
            
            // Difficulty filter
            Box {
                FilterChip(
                    selected = selectedDifficulty != null,
                    onClick = { showDifficultyDropdown = true },
                    label = {
                        Text(
                            text = selectedDifficulty?.name?.lowercase()?.replaceFirstChar { it.uppercase() } ?: "Difficulty",
                            color = if (selectedDifficulty != null) VikingColors.TextDark else VikingColors.TextLight
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = VikingColors.DarkWood,
                        selectedContainerColor = VikingColors.Gold
                    )
                )
                
                DropdownMenu(
                    expanded = showDifficultyDropdown,
                    onDismissRequest = { showDifficultyDropdown = false },
                    modifier = Modifier.background(VikingColors.LightWood)
                ) {
                    // Option to clear difficulty filter
                    DropdownMenuItem(
                        text = { Text("All Difficulties", color = VikingColors.TextDark) },
                        onClick = {
                            onDifficultySelected(null)
                            showDifficultyDropdown = false
                        }
                    )
                    
                    // Add all difficulties
                    RecipeDifficulty.values().forEach { difficulty ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = difficulty.name.lowercase().replaceFirstChar { it.uppercase() },
                                    color = VikingColors.TextDark
                                )
                            },
                            onClick = {
                                onDifficultySelected(difficulty)
                                showDifficultyDropdown = false
                            }
                        )
                    }
                }
            }
            
            // Favorites filter
            FilterChip(
                selected = showFavoritesOnly,
                onClick = { onFavoritesToggled() },
                label = {
                    Text(
                        text = "Favorites",
                        color = if (showFavoritesOnly) VikingColors.TextDark else VikingColors.TextLight
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = if (showFavoritesOnly) VikingColors.DeepRed else VikingColors.Gold
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = VikingColors.DarkWood,
                    selectedContainerColor = VikingColors.Gold
                )
            )
        }
    }
}
