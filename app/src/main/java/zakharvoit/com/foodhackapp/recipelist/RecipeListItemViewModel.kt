package zakharvoit.com.foodhackapp.recipelist

import android.databinding.BaseObservable
import android.databinding.Bindable
import zakharvoit.com.foodhackapp.BR
import zakharvoit.com.foodhackapp.model.Recipe

class RecipeListItemViewModel : BaseObservable() {
    var recipe: Recipe? = null
        @Bindable get() = field
        set(value) { field = value; notifyPropertyChanged(BR.recipe) }
}