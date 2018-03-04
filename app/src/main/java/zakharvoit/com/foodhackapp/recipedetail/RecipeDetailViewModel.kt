package zakharvoit.com.foodhackapp.recipedetail

import android.databinding.BaseObservable
import android.databinding.Bindable
import zakharvoit.com.foodhackapp.BR
import zakharvoit.com.foodhackapp.common.asCalories
import zakharvoit.com.foodhackapp.common.asCarbs
import zakharvoit.com.foodhackapp.common.asFats
import zakharvoit.com.foodhackapp.common.asProtein
import zakharvoit.com.foodhackapp.model.Recipe

class RecipeDetailViewModel : BaseObservable() {
    var recipeInfo: Recipe? = null
        @Bindable get() = field
        set(value)
        {
            field = value;
            notifyChange()
        }

    var calories: String? = null
        @Bindable get() = recipeInfo?.energyValue?.calories?.asCalories() ?: ""

    var fat: String? = null
        @Bindable get() = recipeInfo?.energyValue?.fats?.asFats() ?: ""

    var carb: String? = null
        @Bindable get() = recipeInfo?.energyValue?.carbs?.asCarbs() ?: ""

    var protein: String? = null
        @Bindable get() = recipeInfo?.energyValue?.protein?.asProtein() ?: ""
}