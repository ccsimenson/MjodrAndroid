package com.ccsimenson.mjodr.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Repository for managing traditional Viking mead recipes
 * Used for the Ancient Recipes feature
 */
class MeadRecipeRepository {
    
    /**
     * Get a list of pre-populated traditional Viking mead recipes
     */
    fun getTraditionalRecipes(): List<MeadRecipe> {
        return listOf(
            // Traditional Basic Mead (Skald's First Song)
            MeadRecipe(
                id = "traditional_basic",
                name = "Skald's First Song",
                description = "A simple traditional mead as would have been made in Viking households. The clean honey flavor allows the quality of the honey to shine through.",
                ingredients = listOf(
                    Ingredient("honey", "4 pounds", "(1.8 kg) raw honey"),
                    Ingredient("water", "1 gallon", "(3.8 liters) spring water"),
                    Ingredient("yeast", "1 packet", "mead yeast or wine yeast"),
                    Ingredient("nutrient", "1 teaspoon", "yeast nutrient")
                ),
                instructions = listOf(
                    Instruction(1, "Heat 1/2 gallon of water to about 110°F (43°C)."),
                    Instruction(2, "Stir in the honey until completely dissolved."),
                    Instruction(3, "Add the remaining water to bring the temperature down."),
                    Instruction(4, "Add yeast and yeast nutrient."),
                    Instruction(5, "Transfer to fermenting vessel and attach airlock."),
                    Instruction(6, "Ferment at room temperature for 2-3 weeks."),
                    Instruction(7, "Rack (transfer) to a clean vessel to remove sediment."),
                    Instruction(8, "Age for 3-6 months before bottling."),
                    Instruction(9, "Bottle and allow to age for at least 6 months before drinking.")
                ),
                type = RecipeType.TRADITIONAL,
                difficulty = RecipeDifficulty.BEGINNER,
                preparationTime = "2-3 weeks",
                isFavorite = false
            ),
            
            // Spiced Mead (Winter's Warmth)
            MeadRecipe(
                id = "spiced_mead",
                name = "Winter's Warmth",
                description = "A warming spiced mead perfect for cold nights. The spices enhance the honey's natural sweetness and add complexity to the flavor profile.",
                ingredients = listOf(
                    Ingredient("honey", "4 pounds", "(1.8 kg) raw honey"),
                    Ingredient("water", "1 gallon", "(3.8 liters) spring water"),
                    Ingredient("yeast", "1 packet", "mead yeast"),
                    Ingredient("nutrient", "1 teaspoon", "yeast nutrient"),
                    Ingredient("cinnamon", "2 sticks", ""),
                    Ingredient("cloves", "10", ""),
                    Ingredient("ginger", "1 inch", "fresh, grated"),
                    Ingredient("cardamom", "5 pods", ""),
                    Ingredient("orange peel", "1", "fresh"),
                    Ingredient("nutmeg", "1/4 teaspoon", "ground")
                ),
                instructions = listOf(
                    Instruction(1, "Heat 1/2 gallon of water to about 110°F (43°C)."),
                    Instruction(2, "Stir in the honey until completely dissolved."),
                    Instruction(3, "Add spices and let steep for 15 minutes."),
                    Instruction(4, "Add remaining water and strain out spices."),
                    Instruction(5, "Add yeast and yeast nutrient."),
                    Instruction(6, "Transfer to fermenting vessel and attach airlock."),
                    Instruction(7, "Ferment at room temperature for 3-4 weeks."),
                    Instruction(8, "Rack to remove sediment."),
                    Instruction(9, "Age for 4-8 months before bottling."),
                    Instruction(10, "Bottle and allow to age for at least 6 months before drinking.")
                ),
                type = RecipeType.SPICED,
                difficulty = RecipeDifficulty.INTERMEDIATE,
                preparationTime = "3-4 weeks",
                isFavorite = false
            ),
            
            // Fruit Mead (Berserker's Berries)
            MeadRecipe(
                id = "fruit_mead",
                name = "Berserker's Berries",
                description = "A robust fruit mead made with wild berries, perfect for celebrating victories. The berries add a deep, complex flavor to the honey base.",
                ingredients = listOf(
                    Ingredient("honey", "4 pounds", "(1.8 kg) raw honey"),
                    Ingredient("water", "1 gallon", "(3.8 liters) spring water"),
                    Ingredient("yeast", "1 packet", "mead yeast"),
                    Ingredient("nutrient", "1 teaspoon", "yeast nutrient"),
                    Ingredient("cranberries", "1 pound", "fresh or frozen"),
                    Ingredient("blueberries", "1/2 pound", "fresh or frozen"),
                    Ingredient("blackberries", "1/2 pound", "fresh or frozen"),
                    Ingredient("raspberries", "1/2 pound", "fresh or frozen"),
                    Ingredient("lemon", "1", "juice and zest")
                ),
                instructions = listOf(
                    Instruction(1, "Heat 1/2 gallon of water to about 110°F (43°C)."),
                    Instruction(2, "Stir in the honey until completely dissolved."),
                    Instruction(3, "Add remaining water and bring to a boil."),
                    Instruction(4, "Add fruits and simmer for 15 minutes."),
                    Instruction(5, "Strain out fruits and cool to 70°F (21°C)."),
                    Instruction(6, "Add yeast and yeast nutrient."),
                    Instruction(7, "Transfer to fermenting vessel and attach airlock."),
                    Instruction(8, "Ferment at room temperature for 4-5 weeks."),
                    Instruction(9, "Rack to remove sediment."),
                    Instruction(10, "Age for 6-12 months before bottling."),
                    Instruction(11, "Bottle and allow to age for at least 6 months before drinking.")
                ),
                type = RecipeType.FRUIT,
                difficulty = RecipeDifficulty.ADVANCED,
                preparationTime = "4-5 weeks",
                isFavorite = false
            ),
            
            // Herbal Mead (Healer's Elixir)
            MeadRecipe(
                id = "herbal_mead",
                name = "Healer's Elixir",
                description = "A medicinal mead infused with healing herbs, perfect for both health and celebration. The herbs add a subtle, complex flavor profile.",
                ingredients = listOf(
                    Ingredient("honey", "4 pounds", "(1.8 kg) raw honey"),
                    Ingredient("water", "1 gallon", "(3.8 liters) spring water"),
                    Ingredient("yeast", "1 packet", "mead yeast"),
                    Ingredient("nutrient", "1 teaspoon", "yeast nutrient"),
                    Ingredient("chamomile", "1/4 cup", "dried flowers"),
                    Ingredient("lavender", "1/4 cup", "dried flowers"),
                    Ingredient("lemon balm", "1/4 cup", "dried leaves"),
                    Ingredient("rosemary", "1 tablespoon", "dried"),
                    Ingredient("thyme", "1 tablespoon", "dried"),
                    Ingredient("ginger", "1 inch", "fresh, grated")
                ),
                instructions = listOf(
                    Instruction(1, "Heat 1/2 gallon of water to about 110°F (43°C)."),
                    Instruction(2, "Stir in the honey until completely dissolved."),
                    Instruction(3, "Add remaining water and herbs."),
                    Instruction(4, "Let steep for 30 minutes."),
                    Instruction(5, "Strain out herbs."),
                    Instruction(6, "Add yeast and yeast nutrient."),
                    Instruction(7, "Transfer to fermenting vessel and attach airlock."),
                    Instruction(8, "Ferment at room temperature for 3-4 weeks."),
                    Instruction(9, "Rack to remove sediment."),
                    Instruction(10, "Age for 6-12 months before bottling."),
                    Instruction(11, "Bottle and allow to age for at least 6 months before drinking.")
                ),
                type = RecipeType.HERBAL,
                difficulty = RecipeDifficulty.ADVANCED,
                preparationTime = "3-4 weeks",
                isFavorite = false
            )
        )
    }
    
    /**
     * Filter recipes by type
     */
    fun filterRecipesByType(recipes: List<MeadRecipe>, type: RecipeType): List<MeadRecipe> {
        return recipes.filter { it.type == type }
    }
    
    /**
     * Filter recipes by difficulty
     */
    fun filterRecipesByDifficulty(recipes: List<MeadRecipe>, difficulty: RecipeDifficulty): List<MeadRecipe> {
        return recipes.filter { it.difficulty == difficulty }
    }
    
    /**
     * Search recipes by keyword
     */
    fun searchRecipes(recipes: List<MeadRecipe>, query: String): List<MeadRecipe> {
        if (query.isBlank()) return recipes
        
        val lowercaseQuery = query.lowercase()
        return recipes.filter {
            it.name.lowercase().contains(lowercaseQuery) ||
            it.description.lowercase().contains(lowercaseQuery) ||
            it.ingredients.any { ingredient -> ingredient.name.lowercase().contains(lowercaseQuery) } ||
            it.type.name.lowercase().contains(lowercaseQuery)
        }
    }
    
    /**
     * Get favorite recipes
     */
    fun getFavoriteRecipes(recipes: List<MeadRecipe>): List<MeadRecipe> {
        return recipes.filter { it.isFavorite }
    }
}
