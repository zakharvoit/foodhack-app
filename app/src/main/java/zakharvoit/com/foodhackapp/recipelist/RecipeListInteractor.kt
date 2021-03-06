package zakharvoit.com.foodhackapp.recipelist

import io.reactivex.Single
import zakharvoit.com.foodhackapp.api.FoodhackApi
import zakharvoit.com.foodhackapp.api.dishes.DishesRequest
import zakharvoit.com.foodhackapp.api.dishes.StepResponse
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.Recipe

class RecipeListInteractor(val api: FoodhackApi) : RecipeListContract.Interactor {
    override fun fetchRecipes(goodIngredients: List<Int>, badIngredients: List<Int>): Single<List<Recipe>> {
        return api.getDishes(DishesRequest(goodIngredients, badIngredients))
                .map { response ->
                    response.dishes.map { dish ->
                        Recipe(dish.name, dish.url, dish.timeCooking, dish.img,
                                dish.energyValue, dish.missingIngredients,
                                dish.ingredients.map { i -> Ingredient(i.id, i.name, i.img) },
                                dish.steps.map(StepResponse::text))
                    }
                }
    }
}