package zakharvoit.com.foodhackapp.recipelist

import android.databinding.BaseObservable
import android.databinding.Bindable
import zakharvoit.com.foodhackapp.BR
import zakharvoit.com.foodhackapp.api.dishes.EnergyValue
import zakharvoit.com.foodhackapp.common.asCalories
import zakharvoit.com.foodhackapp.common.asMinutes
import zakharvoit.com.foodhackapp.common.asMissing
import zakharvoit.com.foodhackapp.common.prettyPrint
import zakharvoit.com.foodhackapp.model.Recipe



class RecipeListItemViewModel : BaseObservable() {
    var recipe: Recipe? = null
        @Bindable get() = field
        set(value) {
            field = value;
            notifyChange()
        }

    val energyDetail: String
        @Bindable get() = recipe?.energyValue?.prettyPrint() ?: ""

    val cookTimeMinutes: String
        @Bindable get() = recipe?.cookTimeMinutes?.asMinutes() ?: ""

    val calories: String
        @Bindable get() = recipe?.energyValue?.calories?.asCalories() ?: ""

    val missingIngredients: String
        @Bindable get() = recipe?.missingIngredients?.asMissing() ?: ""

}

