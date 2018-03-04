package zakharvoit.com.foodhackapp.recipelist

import io.reactivex.Single
import zakharvoit.com.foodhackapp.api.FoodhackApi
import zakharvoit.com.foodhackapp.api.dishes.DishesRequest
import zakharvoit.com.foodhackapp.model.RecipePreview

class RecipeListInteractor(val api: FoodhackApi) : RecipeListContract.Interactor {
    override fun fetchRecipes(goodIngredients: List<Int>, badIngredients: List<Int>): Single<List<RecipePreview>> {
        return api.getDishes(DishesRequest(goodIngredients))
                .map { response ->
                    response.dishes.map { dish ->
                        RecipePreview(dish.name, dish.url, dish.timeCooking, dish.img,
                                dish.energyValue)
                    }
                }
    }
}