package zakharvoit.com.foodhackapp.recipelist

import io.reactivex.Single
import zakharvoit.com.foodhackapp.common.BasePresenter
import zakharvoit.com.foodhackapp.common.BaseView
import zakharvoit.com.foodhackapp.model.RecipePreview

interface RecipeListContract {
    interface View : BaseView<Presenter> {
        fun setRecipes(recipes: List<RecipePreview>)
        fun onError(error: String)
    }

    interface Presenter : BasePresenter<View> {
        fun setParams(goodIngredients: List<Int>,
                      badIngredients: List<Int>)
    }

    interface Interactor {
        fun fetchRecipes(goodIngredients: List<Int>,
                         badIngredients: List<Int>): Single<List<RecipePreview>>
    }

    interface Router {
        fun showRecipes(goodIngredients: List<Int>,
                        badIngredients: List<Int>)
    }
}