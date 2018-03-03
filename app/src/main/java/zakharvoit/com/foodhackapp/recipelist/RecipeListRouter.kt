package zakharvoit.com.foodhackapp.recipelist

import android.content.Context
import android.content.Intent
import zakharvoit.com.foodhackapp.main.MainActivity

class RecipeListRouter(val context: Context,
                       val presenter: RecipeListContract.Presenter,
                       val view: RecipeListContract.View) : RecipeListContract.Router {

    override fun showRecipes(goodIngredients: List<Int>, badIngredients: List<Int>) {
        // TODO: rewrite
        presenter.setParams(goodIngredients, badIngredients)
        val intent = Intent(context, RecipeListActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}