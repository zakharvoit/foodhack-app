package zakharvoit.com.foodhackapp.recipelist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import org.koin.android.ext.android.inject
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.model.RecipePreview

// TODO: remove arguments, add save restore logic
class RecipeListFragment : Fragment(), RecipeListContract.View {
    override val presenter by inject<RecipeListContract.Presenter>()
    private lateinit var recipeListView: RecyclerView
    private lateinit var recipeListAdapter: RecipeListAdapter

    init {
        presenter.view = this
    }

    override fun onError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeListView = view.findViewById(R.id.recipe_list_view)
        recipeListAdapter = RecipeListAdapter()
        recipeListView.adapter = recipeListAdapter

        presenter.start()
    }

    override fun setRecipes(recipes: List<RecipePreview>) {
        recipeListAdapter.list = ArrayList(recipes)
    }
}