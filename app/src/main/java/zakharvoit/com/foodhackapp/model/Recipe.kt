package zakharvoit.com.foodhackapp.model

class RecipeIngredient(
        val title: String
)

class Recipe(
        val url: String,
        val cookTimeMinutes: Int,
        val ingredients: RecipeIngredient,
        val imageUrl: String,
        val cookSteps: List<String>
)
