package zakharvoit.com.foodhackapp.ingredientchoose

import android.graphics.drawable.Drawable
import io.reactivex.Single
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.IngredientChooseOption
import java.io.InputStream
import java.net.URL

class IngredientChooseMockInteractor : IngredientChooseContract.Interactor {
//    private val testImageUrl = "http://fitexpert.biz/wp-content/uploads/2017/02/krasnoe-miaso.jpg"
    private val testImageUrl = "http://lenagold.ru/fon/clipart/m/mjas/mjaso18.jpg"

    override fun getNewRandomIngredient(): Single<Ingredient> {
        return Single.fromCallable {
            Ingredient("Тестовый ингредиент", downloadDrawable(testImageUrl))
        }
    }

    override fun setIngredientChooseOption(ingredient: Ingredient, option: IngredientChooseOption) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun downloadDrawable(urlString: String): Drawable {
        val url = URL(urlString)
        url.content
        return Drawable.createFromStream(url.content as InputStream?, "ingredient image")
    }
}