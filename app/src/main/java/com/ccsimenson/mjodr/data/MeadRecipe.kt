package com.ccsimenson.mjodr.data

/**
 * Data model for a traditional mead recipe
 * Used for the Ancient Recipes feature
 */
data class MeadRecipe(
    val id: String,
    val name: String,
    val description: String,
    val ingredients: List<Ingredient>,
    val instructions: List<Instruction>,
    val type: RecipeType,
    val difficulty: RecipeDifficulty,
    val preparationTime: String,
    var isFavorite: Boolean = false,
    val youtubeVideoId: String? = null
)

data class Ingredient(
    val name: String,
    val amount: String,
    val unit: String
)

data class Instruction(
    val number: Int,
    val description: String
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
