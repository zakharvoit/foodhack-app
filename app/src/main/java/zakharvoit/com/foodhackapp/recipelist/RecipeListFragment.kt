package zakharvoit.com.foodhackapp.recipelist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.ext.android.inject
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.model.Recipe

class RecipeListFragment : Fragment(), RecipeListContract.View {
    override val presenter by inject<RecipeListContract.Presenter>()
    private lateinit var recipeListView: RecyclerView
    private lateinit var recipeListAdapter: RecipeListAdapter

    init {
        presenter.view = this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeListView = view.findViewById(R.id.recipe_list_view)
        recipeListAdapter = RecipeListAdapter()
        recipeListView.adapter = recipeListAdapter

        presenter.start()
    }

    override fun setRecipes(recipes: List<Recipe>) {
        recipeListAdapter.list = ArrayList(recipes)
    }
}