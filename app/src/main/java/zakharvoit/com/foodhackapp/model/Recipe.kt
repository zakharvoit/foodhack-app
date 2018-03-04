package zakharvoit.com.foodhackapp.model

import zakharvoit.com.foodhackapp.api.dishes.EnergyValue

class RecipeIngredient(
        val title: String
)

class Recipe(
        val title: String,
        val url: String,
        val cookTimeMinutes: Int,
        val imageUrl: String,
        val energyValue: EnergyValue,
        val missingIngredients: Int
)
