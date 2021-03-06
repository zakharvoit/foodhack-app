package zakharvoit.com.foodhackapp.ingredientchoose

import io.reactivex.Single
import zakharvoit.com.foodhackapp.api.FoodhackApi
import zakharvoit.com.foodhackapp.api.ingredients.IngredientsRequest
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.IngredientChooseOption

class IngredientChooseInteractor(val api: FoodhackApi) : IngredientChooseContract.Interactor {
    private val likedIngredients = ArrayList<Ingredient>()
    private val dislikedIngredients = ArrayList<Ingredient>()

    override fun getRandomIngredients(): Single<List<Ingredient>> {
        val all = ArrayList(likedIngredients)
        all.addAll(dislikedIngredients)
        return api.getIngredients(IngredientsRequest(all.map(Ingredient::id), 10)).map{ response ->
            response.ingredients.map { i -> Ingredient(i.id, i.name, i.img) }
        }
    }
    override fun setIngredientChooseOption(ingredient: Ingredient, option: IngredientChooseOption) {
        when (option) {
            IngredientChooseOption.GOOD -> likedIngredients.add(ingredient)
            IngredientChooseOption.BAD -> dislikedIngredients.add(ingredient)
            IngredientChooseOption.SKIP -> {}
        }
    }

    override fun getLikesInfo(): Single<Pair<List<Int>, List<Int>>> =
            Single.just(Pair(
                    likedIngredients.map(Ingredient::id),
                    dislikedIngredients.map(Ingredient::id)))
}