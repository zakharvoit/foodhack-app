package zakharvoit.com.foodhackapp.api

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import zakharvoit.com.foodhackapp.api.dishes.DishesRequest
import zakharvoit.com.foodhackapp.api.dishes.DishesResponse
import zakharvoit.com.foodhackapp.api.ingredients.IngredientsRequest
import zakharvoit.com.foodhackapp.api.ingredients.IngredientsResponse

interface FoodhackApi {
    @POST("/ingredients/get_list/")
    fun getIngredients(@Body params: IngredientsRequest)
            : Single<IngredientsResponse>

    @POST("/dish/get_list/")
    fun getDishes(@Body params: DishesRequest)
            : Single<DishesResponse>
}