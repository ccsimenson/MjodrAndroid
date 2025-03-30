package com.ccsimenson.mjodr.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.data.MeadRecipe
import com.ccsimenson.mjodr.ui.theme.VikingColors
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Screen for displaying detailed information about a mead recipe
 * Styled with the Viking theme
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(
    recipe: MeadRecipe,
    onBackClick: () -> Unit,
    onFavoriteClick: (String) -> Unit,
    onShareClick: (MeadRecipe) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = VikingColors.Background)
    ) {
        // Top app bar with back button and actions
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = FontFamily.Serif
                    ),
                    color = VikingColors.Gold
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = VikingColors.Gold
                    )
                }
            },
            actions = {
                IconButton(onClick = { onFavoriteClick(recipe.id) }) {
                    Icon(
                        imageVector = if (recipe.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = if (recipe.isFavorite) "Remove from favorites" else "Add to favorites",
                        tint = if (recipe.isFavorite) VikingColors.DeepRed else VikingColors.Gold
                    )
                }
                IconButton(onClick = { onShareClick(recipe) }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share recipe",
                        tint = VikingColors.Gold
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = VikingColors.DarkWood,
                titleContentColor = VikingColors.Gold
            )
        )
        
        // Recipe content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            // Recipe type and difficulty badges
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
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
                        color = VikingColors.TextLight
                    )
                }
                
                Spacer(modifier = Modifier.weight(1f))
                
                // Yield
                Text(
                    text = "Yield: ${recipe.yield}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = VikingColors.TextLight
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Description
            Text(
                text = recipe.description,
                style = MaterialTheme.typography.bodyLarge,
                color = VikingColors.TextLight
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Ingredients section
            Text(
                text = "INGREDIENTS",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                ),
                color = VikingColors.Gold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = VikingColors.LightWood.copy(alpha = 0.9f)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    recipe.ingredients.forEach { ingredient ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(VikingColors.Gold)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = ingredient,
                                style = MaterialTheme.typography.bodyMedium,
                                color = VikingColors.TextDark
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Instructions section
            Text(
                text = "INSTRUCTIONS",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                ),
                color = VikingColors.Gold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = VikingColors.LightWood.copy(alpha = 0.9f)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    recipe.instructions.forEachIndexed { index, instruction ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "${index + 1}.",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = VikingColors.Gold,
                                modifier = Modifier.width(24.dp)
                            )
                            Text(
                                text = instruction,
                                style = MaterialTheme.typography.bodyMedium,
                                color = VikingColors.TextDark
                            )
                        }
                        
                        if (index < recipe.instructions.size - 1) {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Fermentation time
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Timer,
                    contentDescription = null,
                    tint = VikingColors.Gold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Fermentation Time: ${recipe.fermentationTime}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = VikingColors.TextLight
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // YouTube video button (if available)
            if (recipe.youtubeVideoId != null) {
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=${recipe.youtubeVideoId}"))
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = VikingColors.DeepRed,
                        contentColor = VikingColors.TextLight
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Watch Video Tutorial",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
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
