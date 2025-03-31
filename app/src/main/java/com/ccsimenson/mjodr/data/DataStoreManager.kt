package com.ccsimenson.mjodr.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

private val FAVORITE_RECIPES_KEY = stringPreferencesKey("favorite_recipes")

/**
 * Manager for handling data store operations
 */
class DataStoreManager(private val context: Context) {
    
    /**
     * Get the list of favorite recipe IDs
     */
    fun getFavoriteRecipes(): Flow<List<String>> {
        return context.dataStore.data.map { preferences ->
            preferences[FAVORITE_RECIPES_KEY]?.split(',')?.filter { it.isNotBlank() } ?: emptyList()
        }
    }
    
    /**
     * Save the list of favorite recipe IDs
     */
    suspend fun saveFavoriteRecipes(recipes: List<String>) {
        context.dataStore.edit { preferences ->
            preferences[FAVORITE_RECIPES_KEY] = recipes.joinToString(",")
        }
    }
}
