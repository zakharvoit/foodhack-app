package zakharvoit.com.foodhackapp.recipelist

import android.databinding.BaseObservable
import android.databinding.Bindable
import zakharvoit.com.foodhackapp.BR
import zakharvoit.com.foodhackapp.api.dishes.EnergyValue
import zakharvoit.com.foodhackapp.model.RecipePreview



class RecipeListItemViewModel : BaseObservable() {
    var recipe: RecipePreview? = null
        @Bindable get() = field
        set(value) { field = value; notifyPropertyChanged(BR.recipe) }

    val energyDetail: String
        @Bindable get() = recipe?.energyValue?.prettyPrint() ?: ""

    val cookTimeMinutes: String
        @Bindable get() = recipe?.cookTimeMinutes?.asMinutes() ?: ""

    val calories: String
        @Bindable get() = recipe?.energyValue?.calories?.asCalories() ?: ""
}

private fun Int.asMinutes(): String = this.toString() + " мин"

private fun Double.asCalories(): String = this.toString() + " Ккал"

private fun EnergyValue.prettyPrint(): String = "Белки: " + protein + "Ккал: " + calories
