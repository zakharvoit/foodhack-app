package zakharvoit.com.foodhackapp.ingredientchoose

import io.reactivex.Single
import zakharvoit.com.foodhackapp.BasePresenter
import zakharvoit.com.foodhackapp.BaseView
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.IngredientChooseOption

interface IngredientChooseContract {
    interface Presenter : BasePresenter<View> {
    }

    interface Interactor {
        fun getNewRandomIngredient(): Single<Ingredient>
        fun setIngredientChooseOption(ingredient: Ingredient, option: IngredientChooseOption)
    }

    interface View : BaseView<Presenter> {
        fun setIngredient(ingredient: Ingredient)
        fun onError(text: String)
    }
}