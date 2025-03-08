package com.ccsimenson.mjodr.ui.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ccsimenson.mjodr.data.DataStoreManager
import com.ccsimenson.mjodr.data.MeadRecipe
import com.ccsimenson.mjodr.data.MeadRecipeRepository
import com.ccsimenson.mjodr.data.RecipeDifficulty
import com.ccsimenson.mjodr.data.RecipeType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * ViewModel for the Traditional Recipes feature
 * Handles loading, filtering, and favoriting traditional Viking mead recipes
 */
class TraditionalRecipesViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = MeadRecipeRepository()
    private val dataStoreManager = DataStoreManager(application)
    
    // All available recipes
    private val allRecipes = repository.getTraditionalRecipes()
    
    // UI state
    private val _recipes = MutableStateFlow<List<MeadRecipe>>(emptyList())
    val recipes: StateFlow<List<MeadRecipe>> = _recipes.asStateFlow()
    
    var selectedType by mutableStateOf<RecipeType?>(null)
        private set
    
    var selectedDifficulty by mutableStateOf<RecipeDifficulty?>(null)
        private set
    
    var searchQuery by mutableStateOf("")
        private set
    
    var showFavoritesOnly by mutableStateOf(false)
        private set
    
    var isLoading by mutableStateOf(false)
        private set
    
    // Initialize with all recipes
    init {
        loadAllRecipes()
    }
    
    /**
     * Load all recipes and apply any active filters
     */
    private fun loadAllRecipes() {
        viewModelScope.launch {
            isLoading = true
            
            // Update favorite status for all recipes
            allRecipes.forEach { recipe ->
                recipe.isFavorite = dataStoreManager.getFavoriteStatus(recipe.id).first()
            }
            
            // Apply filters
            val filteredRecipes = applyFilters(allRecipes)
            
            _recipes.value = filteredRecipes
            isLoading = false
        }
    }
    
    /**
     * Apply filters to the recipe list
     */
    private fun applyFilters(recipes: List<MeadRecipe>): List<MeadRecipe> {
        var filteredRecipes = recipes
        
        // Filter by type
        selectedType?.let { type ->
            filteredRecipes = filteredRecipes.filter { it.type == type }
        }
        
        // Filter by difficulty
        selectedDifficulty?.let { difficulty ->
            filteredRecipes = filteredRecipes.filter { it.difficulty == difficulty }
        }
        
        // Filter by search query
        if (searchQuery.isNotBlank()) {
            val query = searchQuery.lowercase()
            filteredRecipes = filteredRecipes.filter {
                it.title.lowercase().contains(query) ||
                it.description.lowercase().contains(query) ||
                it.ingredients.any { ingredient -> ingredient.lowercase().contains(query) }
            }
        }
        
        // Filter by favorites
        if (showFavoritesOnly) {
            filteredRecipes = filteredRecipes.filter { it.isFavorite }
        }
        
        return filteredRecipes
    }
    
    /**
     * Toggle the favorite status of a recipe
     */
    fun toggleFavorite(recipeId: String) {
        viewModelScope.launch {
            val recipe = allRecipes.find { it.id == recipeId } ?: return@launch
            val newFavoriteStatus = !recipe.isFavorite
            
            // Update in DataStore
            dataStoreManager.toggleFavoriteStatus(recipeId, newFavoriteStatus)
            
            // Update in memory
            recipe.isFavorite = newFavoriteStatus
            
            // Refresh the list
            _recipes.value = applyFilters(allRecipes)
        }
    }
    
    /**
     * Set the recipe type filter
     */
    fun setTypeFilter(type: RecipeType?) {
        selectedType = type
        loadAllRecipes()
    }
    
    /**
     * Set the recipe difficulty filter
     */
    fun setDifficultyFilter(difficulty: RecipeDifficulty?) {
        selectedDifficulty = difficulty
        loadAllRecipes()
    }
    
    /**
     * Set the search query filter
     */
    fun updateSearchQuery(query: String) {
        searchQuery = query
        loadAllRecipes()
    }
    
    /**
     * Toggle showing favorites only
     */
    fun toggleFavoritesOnly() {
        showFavoritesOnly = !showFavoritesOnly
        loadAllRecipes()
    }
    
    /**
     * Clear all filters
     */
    fun clearFilters() {
        selectedType = null
        selectedDifficulty = null
        searchQuery = ""
        showFavoritesOnly = false
        loadAllRecipes()
    }
}
