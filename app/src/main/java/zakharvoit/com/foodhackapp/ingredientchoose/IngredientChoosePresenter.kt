package zakharvoit.com.foodhackapp.ingredientchoose

import android.content.Intent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.IngredientChooseOption
import zakharvoit.com.foodhackapp.model.Recipe
import zakharvoit.com.foodhackapp.recipelist.RecipeListContract

private const val INGREDIENTS_THRESHOLD = 5

class IngredientChoosePresenter(
        private val interactor: IngredientChooseContract.Interactor,
        private val recipesRouter: RecipeListContract.Router) :
        IngredientChooseContract.Presenter {

    override lateinit var view: IngredientChooseContract.View

    private val ingredients: ArrayList<Ingredient> = ArrayList()

    override fun start() {
        requestMoreIngredients()
    }

    private fun requestMoreIngredients() {
        interactor.getRandomIngredients()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { ingredients ->
                            this.ingredients.addAll(ingredients)
                            view.setIngredients(ingredients)
                        },
                        { throwable ->
                            view.onError(throwable.localizedMessage)
                        })
    }

    override fun onIngredientSwiped(ingredient: Ingredient, option: IngredientChooseOption) {
        this.ingredients.remove(ingredient)
        interactor.setIngredientChooseOption(ingredient, option)
        if (this.ingredients.size < INGREDIENTS_THRESHOLD) requestMoreIngredients()
    }

    override fun showRecipes() {
        interactor.getLikesInfo()
                .subscribe { (good, bad) ->
                    recipesRouter.showRecipes(good, bad)
                }
    }
}