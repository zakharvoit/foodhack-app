package zakharvoit.com.foodhackapp.ingredientchoose.api

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface IngredientsApi {
    @POST("/ingredients/get_list/")
    fun getIngredients(@Body params: IngredientsRequest)
    : Single<IngredientsResponse>
}