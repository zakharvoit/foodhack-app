package zakharvoit.com.foodhackapp.api.dishes

class EnergyValue(
        val carbs: Double,
        fats: Double,
        protein: Double,
        calories: Double)

class Dish(
        val name: String,
        val url: String,
        val timeCooking: Int,
        val energyValue: EnergyValue,
        val missingIngredients: Int,
        val img: String)

class DishesResponse(val dishes: List<Dish>)

