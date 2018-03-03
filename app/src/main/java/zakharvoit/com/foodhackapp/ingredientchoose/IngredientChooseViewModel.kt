package zakharvoit.com.foodhackapp.ingredientchoose

import android.databinding.BaseObservable
import android.databinding.Bindable
import zakharvoit.com.foodhackapp.BR
import zakharvoit.com.foodhackapp.model.Ingredient

class IngredientChooseViewModel : BaseObservable() {
    var isLoading: Boolean = true
        @Bindable get() = field
        set(value) { field = value; notifyPropertyChanged(BR.loading) }

    var ingredient: Ingredient? = null
        @Bindable get() = field
        set(value) { field = value; notifyPropertyChanged(BR.ingredient) }
}