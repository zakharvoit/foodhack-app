package zakharvoit.com.foodhackapp.ingredientchoose

import io.reactivex.Single
import zakharvoit.com.foodhackapp.ingredientchoose.api.IngredientsApi
import zakharvoit.com.foodhackapp.ingredientchoose.api.IngredientsRequest
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.IngredientChooseOption

class IngredientChooseInteractor(val api: IngredientsApi) : IngredientChooseContract.Interactor {
    override fun getRandomIngredients(): Single<List<Ingredient>> {
        return api.getIngredients(IngredientsRequest(listOf(), 10)).map{ response ->
            response.ingredients.map { i -> Ingredient(i.id, i.name, "http://lenagold.ru/fon/clipart/m/mjas/mjaso18.jpg") }
        }
    }

    override fun setIngredientChooseOption(ingredient: Ingredient, option: IngredientChooseOption) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}