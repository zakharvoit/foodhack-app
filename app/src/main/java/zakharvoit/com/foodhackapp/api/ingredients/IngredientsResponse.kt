package zakharvoit.com.foodhackapp.api.ingredients

class IngredientResponse(val id: Int, val name: String, val key: String)

class IngredientsResponse(val ingredients: List<IngredientResponse>)