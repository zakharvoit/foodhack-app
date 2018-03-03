package zakharvoit.com.foodhackapp.ingredientchoose

import io.reactivex.Single
import zakharvoit.com.foodhackapp.BasePresenter
import zakharvoit.com.foodhackapp.BaseView
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.IngredientChooseOption

interface IngredientChooseContract {
    interface Presenter : BasePresenter<View> {
        fun onIngredientSwiped(ingredient: Ingredient, option: IngredientChooseOption)
    }

    interface Interactor {
        fun getRandomIngredients(): Single<List<Ingredient>>
        fun setIngredientChooseOption(ingredient: Ingredient, option: IngredientChooseOption)
    }

    interface View : BaseView<Presenter> {
        fun setIngredients(ingredients: List<Ingredient>)
        fun onError(text: String)
    }
}