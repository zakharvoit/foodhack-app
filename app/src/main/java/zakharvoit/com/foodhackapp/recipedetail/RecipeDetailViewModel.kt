package zakharvoit.com.foodhackapp.recipedetail

import android.databinding.BaseObservable
import android.databinding.Bindable
import zakharvoit.com.foodhackapp.BR
import zakharvoit.com.foodhackapp.model.Recipe

class RecipeDetailViewModel : BaseObservable() {
    var recipeInfo: Recipe? = null
        @Bindable get() = field
        set(value) { field = value; notifyPropertyChanged(BR.recipeInfo) }
}