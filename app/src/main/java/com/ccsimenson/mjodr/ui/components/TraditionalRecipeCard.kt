package com.ccsimenson.mjodr.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.data.MeadRecipe
import com.ccsimenson.mjodr.ui.theme.VikingColors

/**
 * A card component for displaying a traditional Viking mead recipe
 * Styled with the Viking theme colors
 */
@Composable
fun TraditionalRecipeCard(
    recipe: MeadRecipe,
    onRecipeClick: (MeadRecipe) -> Unit,
    onFavoriteClick: (String) -> Unit,
    onShareClick: (MeadRecipe) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onRecipeClick(recipe) },
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
            // Recipe header with title and type
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Title with Viking styling
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    ),
                    color = VikingColors.TextDark,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                
                // Recipe type badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(VikingColors.Gold.copy(alpha = 0.8f))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = recipe.type.name.lowercase().replaceFirstChar { it.uppercase() },
                        style = MaterialTheme.typography.labelMedium,
                        color = VikingColors.TextDark
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Recipe description
            Text(
                text = recipe.description,
                style = MaterialTheme.typography.bodyMedium,
                color = VikingColors.TextDark,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Recipe metadata
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Difficulty badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(getDifficultyColor(recipe.difficulty.name))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = recipe.difficulty.name.lowercase().replaceFirstChar { it.uppercase() },
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White
                    )
                }
                
                Spacer(modifier = Modifier.width(8.dp))
                
                // Fermentation time
                Text(
                    text = "Fermentation: ${recipe.fermentationTime}",
                    style = MaterialTheme.typography.bodySmall,
                    color = VikingColors.TextDark.copy(alpha = 0.7f)
                )
                
                Spacer(modifier = Modifier.weight(1f))
                
                // Action buttons
                IconButton(onClick = { onFavoriteClick(recipe.id) }) {
                    Icon(
                        imageVector = if (recipe.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = if (recipe.isFavorite) "Remove from favorites" else "Add to favorites",
                        tint = if (recipe.isFavorite) VikingColors.DeepRed else VikingColors.TextDark
                    )
                }
                
                IconButton(onClick = { onShareClick(recipe) }) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share recipe",
                        tint = VikingColors.TextDark
                    )
                }
            }
        }
    }
}

/**
 * Get color based on recipe difficulty
 */
@Composable
private fun getDifficultyColor(difficulty: String): Color {
    return when (difficulty.uppercase()) {
        "BEGINNER" -> VikingColors.Green
        "INTERMEDIATE" -> VikingColors.Gold
        "ADVANCED" -> VikingColors.DeepRed
        else -> VikingColors.Gold
    }
}
