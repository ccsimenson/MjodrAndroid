package com.ccsimenson.mjodr.data

/**
 * Data model for a traditional mead recipe
 * Used for the Ancient Recipes feature
 */
data class MeadRecipe(
    val id: String,
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val type: RecipeType,
    val difficulty: RecipeDifficulty,
    val fermentationTime: String,
    val yield: String,
    val isFavorite: Boolean = false,
    val youtubeVideoId: String? = null
)

/**
 * Types of mead recipes
 */
enum class RecipeType {
    TRADITIONAL,
    SPICED,
    FRUIT,
    HERBAL,
    BRAGGOT,
    METHEGLIN,
    MELOMEL,
    CYSER,
    PYMENT,
    HYDROMEL
}

/**
 * Difficulty levels for recipes
 */
enum class RecipeDifficulty {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED
}
