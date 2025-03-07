package com.ccsimenson.mjodr.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
                style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
                color = VikingColors.Gold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // Search bar
            OutlinedTextField(
                value = viewModel.searchQuery,
                onValueChange = viewModel::updateSearchQuery,
                label = { Text(stringResource(R.string.search_recipes), color = VikingColors.Parchment) },
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
                text = stringResource(R.string.search),
                onClick = {
                    viewModel.searchRecipes()
                    keyboardController?.hide()
                },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Loading indicator
            if (viewModel.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(16.dp),
                    color = VikingColors.Gold
                )
            }
            
            // Results
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(searchResults) { video ->
                    RecipeVideoItem(
                        video = video,
                        onClick = { openYoutubeVideo(video, context) },
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
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=${video.id}"))
    context.startActivity(intent)
}
