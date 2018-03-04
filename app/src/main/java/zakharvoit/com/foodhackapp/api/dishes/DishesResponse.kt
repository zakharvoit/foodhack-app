package zakharvoit.com.foodhackapp.api.dishes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class EnergyValue(
        val carbs: Double,
        val fats: Double,
        val protein: Double,
        val calories: Double) : Parcelable

class Dish(
        val name: String,
        val url: String,
        val timeCooking: Int,
        val energyValue: EnergyValue,
        val missingIngredients: Int,
        val img: String)

class DishesResponse(val dishes: List<Dish>)

