package com.ccsimenson.mjodr.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * DataStore manager for storing user preferences
 * Used for storing favorite recipes in the Ancient Recipes feature
 */
class DataStoreManager(private val context: Context) {
    
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "mjodr_preferences")
        
        // Preference keys
        private fun favoriteRecipeKey(recipeId: String) = booleanPreferencesKey("favorite_recipe_$recipeId")
    }
    
    /**
     * Get the favorite status of a recipe
     */
    fun getFavoriteStatus(recipeId: String): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[favoriteRecipeKey(recipeId)] ?: false
        }
    }
    
    /**
     * Toggle the favorite status of a recipe
     */
    suspend fun toggleFavoriteStatus(recipeId: String, isFavorite: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[favoriteRecipeKey(recipeId)] = isFavorite
        }
    }
}
