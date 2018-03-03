package zakharvoit.com.foodhackapp.ingredientchoose.api

import zakharvoit.com.foodhackapp.model.Ingredient

class IngredientResponse(val id: Int, val name: String, val key: String)

class IngredientsResponse(val ingredients: List<IngredientResponse>)