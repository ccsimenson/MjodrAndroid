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
                title = "Skald's First Song",
                description = "A simple traditional mead as would have been made in Viking households. The clean honey flavor allows the quality of the honey to shine through.",
                ingredients = listOf(
                    "4 pounds (1.8 kg) raw honey",
                    "1 gallon (3.8 liters) spring water",
                    "1 packet mead yeast or wine yeast",
                    "1 teaspoon yeast nutrient"
                ),
                instructions = listOf(
                    "Heat 1/2 gallon of water to about 110°F (43°C).",
                    "Stir in the honey until completely dissolved.",
                    "Add the remaining water to bring the temperature down.",
                    "When cooled to room temperature, add the yeast and nutrient.",
                    "Transfer to a fermentation vessel and attach airlock.",
                    "Ferment for 2-3 weeks, then rack to secondary.",
                    "Age for at least 3 months before drinking."
                ),
                type = RecipeType.TRADITIONAL,
                difficulty = RecipeDifficulty.BEGINNER,
                fermentationTime = "3-6 months",
                yield = "1 gallon (about 5 bottles)",
                youtubeVideoId = "2YwkvA9QMjE"
            ),
            
            // Spiced Metheglin (Odin's Wisdom)
            MeadRecipe(
                id = "spiced_metheglin",
                title = "Odin's Wisdom",
                description = "A traditional spiced mead (metheglin) with herbs and spices that Vikings would have had access to through trade routes. Named after the All-Father who sacrificed himself for wisdom.",
                ingredients = listOf(
                    "5 pounds (2.3 kg) wildflower honey",
                    "1 gallon (3.8 liters) spring water",
                    "1 stick cinnamon",
                    "5 whole cloves",
                    "1 star anise",
                    "1 small piece ginger, sliced",
                    "Zest of 1 orange",
                    "1 packet mead yeast",
                    "2 teaspoons yeast nutrient"
                ),
                instructions = listOf(
                    "Heat 1/2 gallon of water to about 160°F (71°C).",
                    "Add all spices and simmer for 10 minutes.",
                    "Remove from heat and stir in honey until dissolved.",
                    "Add remaining water to cool the mixture.",
                    "When cooled to room temperature, strain out spices.",
                    "Add yeast and nutrient, then transfer to fermentation vessel.",
                    "Attach airlock and ferment for 2-3 weeks.",
                    "Rack to secondary and age for 6-12 months."
                ),
                type = RecipeType.METHEGLIN,
                difficulty = RecipeDifficulty.INTERMEDIATE,
                fermentationTime = "6-12 months",
                yield = "1 gallon (about 5 bottles)",
                youtubeVideoId = "PgadPmNfkdU"
            ),
            
            // Berry Melomel (Freyja's Tears)
            MeadRecipe(
                id = "berry_melomel",
                title = "Freyja's Tears",
                description = "A fruit mead made with berries that would have been gathered in Scandinavian forests. Named after the goddess Freyja, whose tears turned to gold.",
                ingredients = listOf(
                    "3 pounds (1.4 kg) wildflower honey",
                    "1 gallon (3.8 liters) spring water",
                    "2 pounds (0.9 kg) mixed berries (blueberries, lingonberries, raspberries)",
                    "1 packet mead yeast",
                    "2 teaspoons yeast nutrient",
                    "1 teaspoon acid blend"
                ),
                instructions = listOf(
                    "Sanitize all equipment thoroughly.",
                    "Heat 1/2 gallon of water to about 110°F (43°C).",
                    "Stir in the honey until completely dissolved.",
                    "Mash berries in a sanitized nylon bag.",
                    "Add berries in bag to primary fermentation vessel.",
                    "Add honey water, remaining water, and other ingredients.",
                    "Stir vigorously to aerate, then add yeast.",
                    "Ferment for 1-2 weeks with fruit, then remove fruit.",
                    "Continue fermentation for another 2-3 weeks.",
                    "Rack to secondary and age for at least 3 months."
                ),
                type = RecipeType.MELOMEL,
                difficulty = RecipeDifficulty.INTERMEDIATE,
                fermentationTime = "4-8 months",
                yield = "1 gallon (about 5 bottles)",
                youtubeVideoId = "k0vHUFGNC0s"
            ),
            
            // Braggot (Thor's Hammer)
            MeadRecipe(
                id = "braggot",
                title = "Thor's Hammer",
                description = "A powerful braggot combining honey and malted barley, similar to what Vikings would have brewed for celebrations and feasts. Named after Thor's mighty hammer, Mjölnir.",
                ingredients = listOf(
                    "3 pounds (1.4 kg) raw honey",
                    "2 pounds (0.9 kg) light malt extract",
                    "1 gallon (3.8 liters) spring water",
                    "1 ounce (28g) hops (traditional varieties)",
                    "1 packet ale yeast",
                    "1 teaspoon yeast nutrient"
                ),
                instructions = listOf(
                    "Heat water to about 160°F (71°C).",
                    "Add malt extract and stir until dissolved.",
                    "Add honey and stir until dissolved.",
                    "Add hops and boil for 60 minutes.",
                    "Cool wort to room temperature.",
                    "Transfer to fermentation vessel, leaving sediment behind.",
                    "Add yeast and nutrient.",
                    "Ferment for 2-3 weeks.",
                    "Rack to secondary and age for 1-2 months.",
                    "Bottle with priming sugar for carbonation."
                ),
                type = RecipeType.BRAGGOT,
                difficulty = RecipeDifficulty.ADVANCED,
                fermentationTime = "2-3 months",
                yield = "1 gallon (about 10 bottles)",
                youtubeVideoId = "3tpXzD8jXO0"
            ),
            
            // Herbal Mead (Eir's Remedy)
            MeadRecipe(
                id = "herbal_mead",
                title = "Eir's Remedy",
                description = "A healing herbal mead inspired by Viking medicinal traditions. Named after Eir, the goddess of healing in Norse mythology.",
                ingredients = listOf(
                    "3 pounds (1.4 kg) raw honey",
                    "1 gallon (3.8 liters) spring water",
                    "1 handful fresh thyme",
                    "1 handful fresh mint",
                    "1 small piece ginger, sliced",
                    "1 teaspoon dried yarrow",
                    "1 packet mead yeast",
                    "1 teaspoon yeast nutrient"
                ),
                instructions = listOf(
                    "Heat 1/2 gallon of water to about 160°F (71°C).",
                    "Add herbs and simmer for 10 minutes.",
                    "Remove from heat and stir in honey until dissolved.",
                    "Add remaining water to cool the mixture.",
                    "When cooled to room temperature, strain out herbs.",
                    "Add yeast and nutrient, then transfer to fermentation vessel.",
                    "Attach airlock and ferment for 2-3 weeks.",
                    "Rack to secondary and age for 3-6 months."
                ),
                type = RecipeType.HERBAL,
                difficulty = RecipeDifficulty.INTERMEDIATE,
                fermentationTime = "3-6 months",
                yield = "1 gallon (about 5 bottles)",
                youtubeVideoId = "9RL_xXMwuDE"
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
            it.title.lowercase().contains(lowercaseQuery) ||
            it.description.lowercase().contains(lowercaseQuery) ||
            it.ingredients.any { ingredient -> ingredient.lowercase().contains(lowercaseQuery) } ||
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
