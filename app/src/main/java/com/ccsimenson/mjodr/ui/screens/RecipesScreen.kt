package com.ccsimenson.mjodr.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.ccsimenson.mjodr.ui.components.*
import com.ccsimenson.mjodr.ui.components.FilterButton
import com.ccsimenson.mjodr.ui.components.TraditionalRecipeCard
import com.ccsimenson.mjodr.ui.viewmodels.TraditionalRecipesViewModel
import com.ccsimenson.mjodr.data.RecipeDifficulty
import com.ccsimenson.mjodr.data.RecipeType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesScreen(
    viewModel: TraditionalRecipesViewModel,
    onRecipeClick: (String) -> Unit
) {
    val recipes by viewModel.recipes.collectAsState()
    var searchQuery by remember { mutableStateOf(TextFieldValue()) }
    val keyboardController = LocalSoftwareKeyboardController.current
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Search bar
        TextField(
            value = searchQuery,
            onValueChange = { 
                searchQuery = it
                viewModel.updateSearchQuery(it.text)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            label = { Text("Search recipes") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search")
            },
            trailingIcon = {
                IconButton(onClick = { keyboardController?.hide() }) {
                    Icon(Icons.Default.FilterList, contentDescription = "Filter")
                }
            }
        )

        // Filters
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterButton(
                text = "Type",
                isSelected = viewModel.selectedType != null
            ) { 
                viewModel.setTypeFilter(null)
            }
            FilterButton(
                text = "Difficulty",
                isSelected = viewModel.selectedDifficulty != null
            ) { 
                viewModel.setDifficultyFilter(null)
            }
            Switch(
                checked = viewModel.showFavoritesOnly,
                onCheckedChange = { viewModel.toggleFavoritesOnly() }
            )
        }

        // Recipe list
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recipes) { recipe ->
                TraditionalRecipeCard(
                    recipe = recipe,
                    onCardClick = { onRecipeClick(recipe.id) },
                    onFavoriteClick = { viewModel.toggleFavorite(recipe.id) }
                )
            }
        }
    }
}

@Composable
fun TraditionalRecipesTab(
    recipes: List<MeadRecipe>,
    isLoading: Boolean,
    searchQuery: String,
    selectedType: RecipeType?,
    selectedDifficulty: RecipeDifficulty?,
    showFavoritesOnly: Boolean,
    onSearchQueryChange: (String) -> Unit,
    onTypeSelected: (RecipeType?) -> Unit,
    onDifficultySelected: (RecipeDifficulty?) -> Unit,
    onFavoritesToggled: () -> Unit,
    onClearFilters: () -> Unit,
    onRecipeClick: (MeadRecipe) -> Unit,
    onFavoriteClick: (String) -> Unit,
    onShareClick: (MeadRecipe) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Search and filter row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Search field
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                label = { Text("Search recipes") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { 
                    keyboardController?.hide()
                    onSearchQueryChange(searchQuery) // Trigger search when Enter is pressed
                })
            )
            
            // Type filter
            FilterButton(
                selected = selectedType,
                options = RecipeType.values(),
                onSelected = onTypeSelected,
                label = "Type"
            )
            
            // Difficulty filter
            FilterButton(
                selected = selectedDifficulty,
                options = RecipeDifficulty.values(),
                onSelected = onDifficultySelected,
                label = "Difficulty"
            )
            
            // Favorites toggle
            FilterButton(
                selected = if (showFavoritesOnly) RecipeDifficulty.EASY else null,
                options = listOf(RecipeDifficulty.EASY),
                onSelected = { if (it == RecipeDifficulty.EASY) onFavoritesToggled() else onClearFilters() },
                label = "Favorites"
            )
        }
        
        // Recipes list
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(recipes) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    onFavoriteClick = { onFavoriteClick(recipe.id) },
                    onShareClick = { onShareClick(recipe) },
                    onClick = { onRecipeClick(recipe) }
                )
            }
        }
    }
}

@Composable
fun FilterButton(
    selected: Any?,
    options: Array<out Any>,
    onSelected: (Any?) -> Unit,
    label: String
) {
    OutlinedButton(
        onClick = {
            val newSelection = if (selected == null) options.first() else null
            onSelected(newSelection)
        }
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = FontFamily.Serif
            )
        )
    }
}

@Composable
fun RecipeCard(
    recipe: MeadRecipe,
    onFavoriteClick: () -> Unit,
    onShareClick: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = VikingColors.LightWood
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Recipe title
            Text(
                text = recipe.name,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                ),
                color = VikingColors.Gold
            )
            
            // Recipe details
            Text(
                text = "${recipe.type} • ${recipe.difficulty} • ${recipe.preparationTime}h",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily.Serif
                ),
                color = VikingColors.DarkWood
            )
            
            // Actions row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Favorite button
                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = if (recipe.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (recipe.isFavorite) VikingColors.Gold else VikingColors.DarkWood
                    )
                }
                
                // Share button
                IconButton(
                    onClick = onShareClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = VikingColors.DarkWood
                    )
                }
            }
        }
    }
}

@Composable
fun RecipeDetailScreen(
    recipe: MeadRecipe,
    onBackClick: () -> Unit,
    onFavoriteClick: (String) -> Unit,
    onShareClick: (MeadRecipe) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back button
            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = VikingColors.Gold
                )
            }
            
            // Recipe name
            Text(
                text = recipe.name,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                ),
                color = VikingColors.Gold
            )
            
            // Favorite button
            IconButton(
                onClick = { onFavoriteClick(recipe.id) }
            ) {
                Icon(
                    imageVector = if (recipe.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = if (recipe.isFavorite) VikingColors.Gold else VikingColors.DarkWood
                )
            }
        }
        
        // Recipe details
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                // Description
                Text(
                    text = recipe.description,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = FontFamily.Serif
                    ),
                    color = VikingColors.DarkWood
                )
                
                // Ingredients
                Text(
                    text = "Ingredients:",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    ),
                    color = VikingColors.Gold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                
                recipe.ingredients.forEach { ingredient ->
                    Text(
                        text = "• ${ingredient.amount} ${ingredient.unit} ${ingredient.name}",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontFamily = FontFamily.Serif
                        ),
                        color = VikingColors.DarkWood
                    )
                }
                
                // Instructions
                Text(
                    text = "Instructions:",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    ),
                    color = VikingColors.Gold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                
                recipe.instructions.forEach { step ->
                    Text(
                        text = "${step.number}. ${step.description}",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontFamily = FontFamily.Serif
                        ),
                        color = VikingColors.DarkWood
                    )
                }
            }
        }
        
        // Share button
        Button(
            onClick = { onShareClick(recipe) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = VikingColors.Gold,
                contentColor = VikingColors.DarkWood
            )
        ) {
            Text(
                text = "Share Recipe",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

fun shareRecipe(recipe: MeadRecipe, context: android.content.Context) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, recipe.name)
        putExtra(Intent.EXTRA_TEXT, "${recipe.name}\n${recipe.description}")
    }
    
    context.startActivity(
        Intent.createChooser(shareIntent, "Share recipe")
    )
}
