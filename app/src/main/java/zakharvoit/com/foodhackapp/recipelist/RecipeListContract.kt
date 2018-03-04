package zakharvoit.com.foodhackapp.recipelist

import io.reactivex.Single
import zakharvoit.com.foodhackapp.common.BasePresenter
import zakharvoit.com.foodhackapp.common.BaseView
import zakharvoit.com.foodhackapp.model.Recipe

interface RecipeListContract {
    interface View : BaseView<Presenter> {
        fun setRecipes(recipes: List<Recipe>)
        fun onError(error: String)
    }

    interface Presenter : BasePresenter<View> {
        fun setParams(goodIngredients: List<Int>,
                      badIngredients: List<Int>)
    }

    interface Interactor {
        fun fetchRecipes(goodIngredients: List<Int>,
                         badIngredients: List<Int>): Single<List<Recipe>>
    }

    interface Router {
        fun showRecipes(goodIngredients: List<Int>,
                        badIngredients: List<Int>)
        fun showRecipeDetails(recipe: Recipe)
    }
}