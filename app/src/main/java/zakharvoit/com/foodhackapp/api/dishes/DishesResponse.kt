package zakharvoit.com.foodhackapp.api.dishes

class EnergyValue(
        val carbs: Double,
        val fats: Double,
        val protein: Double,
        val calories: Double)

class Dish(
        val name: String,
        val url: String,
        val timeCooking: Int,
        val energyValue: EnergyValue,
        val missingIngredients: Int,
        val img: String)

class DishesResponse(val dishes: List<Dish>)

