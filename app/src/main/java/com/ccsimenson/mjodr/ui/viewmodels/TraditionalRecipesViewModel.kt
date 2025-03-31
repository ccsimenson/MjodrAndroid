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
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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

    private var _isFavorite by mutableStateOf(false)
    
    init {
        loadAllRecipes()
    }
    
    fun loadAllRecipes() {
        viewModelScope.launch {
            isLoading = true
            dataStoreManager.getFavoriteRecipes()
                .catch { e -> println("Error loading favorites: $e") }
                .onEach { favorites ->
                    val updatedRecipes = allRecipes.map { recipe ->
                        recipe.copy(isFavorite = favorites.contains(recipe.id))
                    }
                    _recipes.value = updatedRecipes
                }
                .launchIn(viewModelScope)
            isLoading = false
        }
    }
    
    fun updateSearchQuery(query: String) {
        searchQuery = query
        filterRecipes()
    }
    
    fun setTypeFilter(type: RecipeType?) {
        selectedType = type
        filterRecipes()
    }
    
    fun setDifficultyFilter(difficulty: RecipeDifficulty?) {
        selectedDifficulty = difficulty
        filterRecipes()
    }
    
    fun toggleFavoritesOnly() {
        showFavoritesOnly = !showFavoritesOnly
        filterRecipes()
    }
    
    fun clearFilters() {
        selectedType = null
        selectedDifficulty = null
        showFavoritesOnly = false
        filterRecipes()
    }
    
    private fun filterRecipes() {
        viewModelScope.launch {
            isLoading = true
            val filtered = allRecipes.filter { recipe ->
                val matchesSearch = searchQuery.isEmpty() ||
                    recipe.name.lowercase().contains(searchQuery.lowercase()) ||
                    recipe.description.lowercase().contains(searchQuery.lowercase())
                
                val matchesType = selectedType == null || recipe.type == selectedType
                val matchesDifficulty = selectedDifficulty == null || recipe.difficulty == selectedDifficulty
                val isFavorite = recipe.isFavorite
                
                matchesSearch && matchesType && matchesDifficulty && (!showFavoritesOnly || isFavorite)
            }
            _recipes.value = filtered
            isLoading = false
        }
    }
    
    fun toggleFavorite(recipeId: String) {
        viewModelScope.launch {
            dataStoreManager.getFavoriteRecipes()
                .catch { e -> println("Error loading favorites: $e") }
                .onEach { currentFavorites ->
                    val newFavorites = if (currentFavorites.contains(recipeId)) {
                        currentFavorites - recipeId
                    } else {
                        currentFavorites + recipeId
                    }
                    dataStoreManager.saveFavoriteRecipes(newFavorites)
                    loadAllRecipes()
                }
                .launchIn(viewModelScope)
        }
    }
}
