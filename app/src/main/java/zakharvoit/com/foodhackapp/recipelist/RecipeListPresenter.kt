package zakharvoit.com.foodhackapp.recipelist

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import zakharvoit.com.foodhackapp.model.Recipe

class RecipeListPresenter(val interactor: RecipeListContract.Interactor):
        RecipeListContract.Presenter {

    override lateinit var view: RecipeListContract.View
    private lateinit var goodIngredients: List<Int>
    private lateinit var badIngredients: List<Int>
    private val recipes = ArrayList<Recipe>()

    override fun start() {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        interactor.fetchRecipes(goodIngredients, badIngredients)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { recipes -> this.recipes.addAll(recipes); view.setRecipes(recipes) },
                        { throwable -> view.onError(throwable.localizedMessage) }
                )
    }

    override fun setParams(goodIngredients: List<Int>, badIngredients: List<Int>) {
        this.goodIngredients = goodIngredients
        this.badIngredients = badIngredients
    }
}