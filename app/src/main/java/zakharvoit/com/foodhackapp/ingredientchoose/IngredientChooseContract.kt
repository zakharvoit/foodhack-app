package zakharvoit.com.foodhackapp.ingredientchoose

import io.reactivex.Single
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.IngredientChooseOption

interface IngredientChooseContract {
    interface Presenter {
        fun start()
    }

    interface Interactor {
        fun getNewRandomIngredient(): Single<List<Ingredient>>
        fun setIngredientChooseOption(ingredient: Ingredient, option: IngredientChooseOption)
    }

    interface View {
        fun setIngredient(ingredient: Ingredient)
        fun setOnIngredientSwipeCallback(option: IngredientChooseOption)
    }
}