package zakharvoit.com.foodhackapp.api.dishes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import zakharvoit.com.foodhackapp.api.ingredients.IngredientResponse

@Parcelize
class EnergyValue(
        val carbs: Double,
        val fats: Double,
        val protein: Double,
        val calories: Double) : Parcelable

class StepResponse(
        val text: String
)

class Dish(
        val name: String,
        val url: String,
        val timeCooking: Int,
        val energyValue: EnergyValue,
        val missingIngredients: Int,
        val img: String,
        val ingredients: List<IngredientResponse>,
        val steps: List<StepResponse>)

class DishesResponse(val dishes: List<Dish>)

