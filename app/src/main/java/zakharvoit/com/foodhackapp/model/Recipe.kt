package zakharvoit.com.foodhackapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import zakharvoit.com.foodhackapp.api.dishes.EnergyValue

@Parcelize
class Recipe (
        val title: String,
        val url: String,
        val cookTimeMinutes: Int,
        val imageUrl: String,
        val energyValue: EnergyValue,
        val missingIngredients: Int
) : Parcelable
