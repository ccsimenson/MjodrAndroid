package com.ccsimenson.mjodr.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.YouTube
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.data.MeadRecipe
import com.ccsimenson.mjodr.data.RecipeDifficulty
import com.ccsimenson.mjodr.data.RecipeType
import com.ccsimenson.mjodr.data.YoutubeVideo
import com.ccsimenson.mjodr.ui.components.*
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.viewmodels.RecipesViewModel
import com.ccsimenson.mjodr.ui.viewmodels.TraditionalRecipesViewModel
import com.ccsimenson.mjodr.ui.viewmodels.ViewModelFactory

/**
 * Ancient Recipes screen with both traditional recipes and YouTube recipe search functionality
 * Styled with the Viking theme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RecipesScreen(
    onNavigateBack: () -> Unit,
    recipesViewModel: RecipesViewModel = viewModel(),
    traditionalViewModel: TraditionalRecipesViewModel = viewModel(
        factory = remember { 
            ViewModelFactory(LocalContext.current.applicationContext as android.app.Application) 
        }
    )
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val searchResults by recipesViewModel.searchResults.collectAsState()
    val traditionalRecipes by traditionalViewModel.recipes.collectAsState()
    
    var selectedTab by remember { mutableStateOf(0) }
    var selectedRecipe by remember { mutableStateOf<MeadRecipe?>(null) }
    
    // Load default recipes when the screen is first displayed
    LaunchedEffect(Unit) {
        recipesViewModel.loadDefaultRecipes()
        traditionalViewModel.loadAllRecipes()
    }
    
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = VikingColors.Background
    ) {
        if (selectedRecipe != null) {
            // Show recipe detail screen
            RecipeDetailScreen(
                recipe = selectedRecipe!!,
                onBackClick = { selectedRecipe = null },
                onFavoriteClick = { traditionalViewModel.toggleFavorite(it) },
                onShareClick = { shareRecipe(it, context) }
            )
        } else {
            // Show main recipes screen with tabs
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header
                Text(
                    text = stringResource(R.string.ancient_recipes),
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    ),
                    color = VikingColors.Gold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Tabs
                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = VikingColors.DarkWood,
                    contentColor = VikingColors.Gold,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                            color = VikingColors.Gold
                        )
                    }
                ) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        text = {
                            Text(
                                "Traditional Recipes",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontFamily = FontFamily.Serif
                                )
                            )
                        },
                        selectedContentColor = VikingColors.Gold,
                        unselectedContentColor = VikingColors.LightWood
                    )
                    
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        icon = {
                            Icon(Icons.Default.YouTube, contentDescription = null)
                        },
                        text = {
                            Text(
                                "YouTube Recipes",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontFamily = FontFamily.Serif
                                )
                            )
                        },
                        selectedContentColor = VikingColors.Gold,
                        unselectedContentColor = VikingColors.LightWood
                    )
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Tab content
                when (selectedTab) {
                    0 -> {
                        // Traditional recipes tab
                        TraditionalRecipesTab(
                            recipes = traditionalRecipes,
                            isLoading = traditionalViewModel.isLoading,
                            searchQuery = traditionalViewModel.searchQuery,
                            selectedType = traditionalViewModel.selectedType,
                            selectedDifficulty = traditionalViewModel.selectedDifficulty,
                            showFavoritesOnly = traditionalViewModel.showFavoritesOnly,
                            onSearchQueryChange = traditionalViewModel::updateSearchQuery,
                            onTypeSelected = traditionalViewModel::setTypeFilter,
                            onDifficultySelected = traditionalViewModel::setDifficultyFilter,
                            onFavoritesToggled = traditionalViewModel::toggleFavoritesOnly,
                            onClearFilters = traditionalViewModel::clearFilters,
                            onRecipeClick = { selectedRecipe = it },
                            onFavoriteClick = traditionalViewModel::toggleFavorite,
                            onShareClick = { shareRecipe(it, context) }
                        )
                    }
                    1 -> {
                        // YouTube recipes tab
                        YouTubeRecipesTab(
                            searchResults = searchResults,
                            isLoading = recipesViewModel.isLoading,
                            searchQuery = recipesViewModel.searchQuery,
                            onSearchQueryChange = recipesViewModel::updateSearchQuery,
                            onSearch = {
                                recipesViewModel.searchRecipes()
                                keyboardController?.hide()
                            },
                            onVideoClick = { openYoutubeVideo(it, context) }
                        )
                    }
                }
            }
        }
    }
}

/**
 * Tab content for traditional Viking mead recipes
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun TraditionalRecipesTab(
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
    val keyboardController = LocalSoftwareKeyboardController.current
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            label = { Text(stringResource(R.string.search_hint), color = VikingColors.TextLight) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VikingColors.Gold,
                unfocusedBorderColor = VikingColors.LightWood,
                focusedLabelColor = VikingColors.Gold,
                unfocusedLabelColor = VikingColors.LightWood,
                cursorColor = VikingColors.Gold,
                focusedTextColor = VikingColors.TextLight,
                unfocusedTextColor = VikingColors.TextLight
            ),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()
                }
            ),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = VikingColors.Gold
                )
            }
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Filters
        RecipeFilters(
            selectedType = selectedType,
            selectedDifficulty = selectedDifficulty,
            showFavoritesOnly = showFavoritesOnly,
            onTypeSelected = onTypeSelected,
            onDifficultySelected = onDifficultySelected,
            onFavoritesToggled = onFavoritesToggled,
            onClearFilters = onClearFilters
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Loading indicator
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = VikingColors.Gold
                )
            }
        }
        
        // Recipe list
        if (recipes.isEmpty() && !isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.no_recipes),
                    style = MaterialTheme.typography.bodyLarge,
                    color = VikingColors.TextLight
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(recipes) { recipe ->
                    TraditionalRecipeCard(
                        recipe = recipe,
                        onRecipeClick = onRecipeClick,
                        onFavoriteClick = onFavoriteClick,
                        onShareClick = onShareClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

/**
 * Tab content for YouTube mead recipes
 */
@Composable
private fun YouTubeRecipesTab(
    searchResults: List<YoutubeVideo>,
    isLoading: Boolean,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    onVideoClick: (YoutubeVideo) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Search bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            label = { Text(stringResource(R.string.search_hint), color = VikingColors.TextLight) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VikingColors.Gold,
                unfocusedBorderColor = VikingColors.LightWood,
                focusedLabelColor = VikingColors.Gold,
                unfocusedLabelColor = VikingColors.LightWood,
                cursorColor = VikingColors.Gold,
                focusedTextColor = VikingColors.TextLight,
                unfocusedTextColor = VikingColors.TextLight
            ),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = { onSearch() }
            ),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = VikingColors.Gold
                )
            }
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Search button
        VikingButton(
            text = stringResource(R.string.search),
            onClick = onSearch,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Loading indicator
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = VikingColors.Gold
                )
            }
        }
        
        // Results
        if (searchResults.isEmpty() && !isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.no_recipes),
                    style = MaterialTheme.typography.bodyLarge,
                    color = VikingColors.TextLight
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(searchResults) { video ->
                    RecipeVideoItem(
                        video = video,
                        onClick = onVideoClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

/**
 * Opens a YouTube video in the YouTube app or browser
 */
private fun openYoutubeVideo(video: YoutubeVideo, context: android.content.Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(video.videoUrl))
    context.startActivity(intent)
}

/**
 * Shares a recipe via Android's share functionality
 */
private fun shareRecipe(recipe: MeadRecipe, context: android.content.Context) {
    val shareText = buildString {
        append("${recipe.title} - Traditional Viking Mead Recipe\n\n")
        append("${recipe.description}\n\n")
        
        append("INGREDIENTS:\n")
        recipe.ingredients.forEach { ingredient ->
            append("• $ingredient\n")
        }
        append("\n")
        
        append("INSTRUCTIONS:\n")
        recipe.instructions.forEachIndexed { index, instruction ->
            append("${index + 1}. $instruction\n")
        }
        append("\n")
        
        append("Difficulty: ${recipe.difficulty.name.lowercase().replaceFirstChar { it.uppercase() }}\n")
        append("Fermentation Time: ${recipe.fermentationTime}\n")
        append("Yield: ${recipe.yield}\n\n")
        
        append("Shared from the Mjöðr Calculator App")
    }
    
    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, shareText)
        type = "text/plain"
    }
    
    val shareIntent = Intent.createChooser(sendIntent, "Share Recipe")
    context.startActivity(shareIntent)
}
