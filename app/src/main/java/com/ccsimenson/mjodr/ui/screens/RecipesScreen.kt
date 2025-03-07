package com.ccsimenson.mjodr.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ccsimenson.mjodr.R
import com.ccsimenson.mjodr.data.YoutubeVideo
import com.ccsimenson.mjodr.ui.components.RecipeVideoItem
import com.ccsimenson.mjodr.ui.components.VikingButton
import com.ccsimenson.mjodr.ui.theme.VikingColors
import com.ccsimenson.mjodr.ui.viewmodels.RecipesViewModel

/**
 * Ancient Recipes screen with YouTube recipe search functionality
 * Styled with the Viking theme
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RecipesScreen(
    onNavigateBack: () -> Unit,
    viewModel: RecipesViewModel = viewModel()
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val searchResults by viewModel.searchResults.collectAsState()
    
    // Load default recipes when the screen is first displayed
    LaunchedEffect(Unit) {
        viewModel.loadDefaultRecipes()
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
                text = stringResource(R.string.ancient_recipes),
                style = MaterialTheme.typography.headlineLarge,
                color = VikingColors.Gold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // Search bar
            OutlinedTextField(
                value = viewModel.searchQuery,
                onValueChange = { viewModel.updateSearchQuery(it) },
                label = { Text(stringResource(R.string.search_hint), color = VikingColors.Parchment) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = VikingColors.Gold,
                    unfocusedBorderColor = VikingColors.LightWood,
                    focusedLabelColor = VikingColors.Gold,
                    unfocusedLabelColor = VikingColors.LightWood,
                    cursorColor = VikingColors.Gold,
                    textColor = VikingColors.Parchment
                ),
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        viewModel.searchRecipes()
                        keyboardController?.hide()
                    }
                ),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Search button
            VikingButton(
                text = stringResource(R.string.search_recipes),
                onClick = {
                    viewModel.searchRecipes()
                    keyboardController?.hide()
                },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Results or loading indicator
            Box(modifier = Modifier.weight(1f)) {
                when {
                    viewModel.isLoading -> {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                            color = VikingColors.Gold
                        )
                    }
                    viewModel.errorMessage != null -> {
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = viewModel.errorMessage ?: "Unknown error",
                                color = VikingColors.Parchment,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            VikingButton(
                                text = stringResource(R.string.try_again),
                                onClick = { viewModel.searchRecipes() }
                            )
                        }
                    }
                    searchResults.isEmpty() -> {
                        Text(
                            text = stringResource(R.string.no_recipes),
                            color = VikingColors.Parchment,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    else -> {
                        LazyColumn {
                            items(searchResults) { video ->
                                RecipeVideoItem(
                                    video = video,
                                    onClick = { selectedVideo ->
                                        // Open the video in YouTube app or browser
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(selectedVideo.videoUrl))
                                        context.startActivity(intent)
                                    }
                                )
                            }
                            
                            // Load more button if there are more results
                            item {
                                if (searchResults.isNotEmpty()) {
                                    VikingButton(
                                        text = stringResource(R.string.load_more),
                                        onClick = { viewModel.loadNextPage() },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
