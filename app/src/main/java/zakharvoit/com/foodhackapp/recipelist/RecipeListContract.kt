package zakharvoit.com.foodhackapp.recipelist

import zakharvoit.com.foodhackapp.BasePresenter
import zakharvoit.com.foodhackapp.BaseView
import zakharvoit.com.foodhackapp.model.Recipe

interface RecipeListContract {
    interface View : BaseView<Presenter> {
        fun setRecipes(recipes: List<Recipe>)
    }

    interface Presenter : BasePresenter<View> {
    }

    interface Interactor {
        fun fetchRecipes(goodIngredients: List<Int>,
                         badIngredients: List<Int>)
    }
}