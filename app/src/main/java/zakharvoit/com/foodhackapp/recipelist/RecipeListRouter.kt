package zakharvoit.com.foodhackapp.recipelist

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import zakharvoit.com.foodhackapp.model.Recipe
import zakharvoit.com.foodhackapp.recipedetail.RecipeDetailActivity

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

    override fun showRecipeDetails(recipe: Recipe) {
        val intent = Intent(context, RecipeDetailActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra("recipe", recipe as Parcelable)
        context.startActivity(intent)
    }
}