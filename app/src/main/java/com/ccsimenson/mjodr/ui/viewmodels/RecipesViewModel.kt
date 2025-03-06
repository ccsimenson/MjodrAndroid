package com.ccsimenson.mjodr.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ccsimenson.mjodr.data.YoutubeRepository
import com.ccsimenson.mjodr.data.YoutubeSearchResponse
import com.ccsimenson.mjodr.data.YoutubeVideo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Ancient Recipes screen
 * Handles YouTube API search operations and UI state
 */
class RecipesViewModel : ViewModel() {
    
    private val repository = YoutubeRepository()
    
    // UI state
    var searchQuery by mutableStateOf("")
        private set
    
    var isLoading by mutableStateOf(false)
        private set
    
    var errorMessage by mutableStateOf<String?>(null)
        private set
    
    private val _searchResults = MutableStateFlow<List<YoutubeVideo>>(emptyList())
    val searchResults: StateFlow<List<YoutubeVideo>> = _searchResults.asStateFlow()
    
    private var nextPageToken: String? = null
    private var prevPageToken: String? = null
    
    /**
     * Update the search query
     */
    fun updateSearchQuery(query: String) {
        searchQuery = query
    }
    
    /**
     * Search for mead recipes on YouTube
     */
    fun searchRecipes() {
        if (searchQuery.isBlank() && _searchResults.value.isEmpty()) {
            // If no query and no previous results, load default recipes
            loadDefaultRecipes()
            return
        }
        
        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null
                
                val response = repository.searchMeadRecipes(searchQuery)
                handleSearchResponse(response)
            } catch (e: Exception) {
                errorMessage = "Failed to load recipes: ${e.message}"
                _searchResults.value = emptyList()
            } finally {
                isLoading = false
            }
        }
    }
    
    /**
     * Load the next page of results
     */
    fun loadNextPage() {
        if (nextPageToken == null) return
        
        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null
                
                val response = repository.searchMeadRecipes(searchQuery, nextPageToken)
                handleSearchResponse(response)
            } catch (e: Exception) {
                errorMessage = "Failed to load more recipes: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
    
    /**
     * Load default traditional mead recipes
     */
    fun loadDefaultRecipes() {
        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null
                
                // Use "traditional viking mead" as default search
                val response = repository.searchMeadRecipes("traditional viking mead")
                handleSearchResponse(response)
            } catch (e: Exception) {
                errorMessage = "Failed to load default recipes: ${e.message}"
                _searchResults.value = emptyList()
            } finally {
                isLoading = false
            }
        }
    }
    
    /**
     * Handle the search response
     */
    private fun handleSearchResponse(response: YoutubeSearchResponse) {
        _searchResults.value = response.items
        nextPageToken = response.nextPageToken
        prevPageToken = response.prevPageToken
    }
    
    /**
     * Clear search results
     */
    fun clearResults() {
        _searchResults.value = emptyList()
        nextPageToken = null
        prevPageToken = null
        searchQuery = ""
    }
}
