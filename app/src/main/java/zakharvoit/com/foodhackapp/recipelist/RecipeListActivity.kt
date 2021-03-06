package zakharvoit.com.foodhackapp.recipelist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import org.koin.android.ext.android.inject
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.model.Recipe

// TODO: USE FRAGMENT NOT ACTIVITY
class RecipeListActivity: AppCompatActivity(), RecipeListContract.View {
    override val presenter by inject<RecipeListContract.Presenter>()
    private lateinit var recipeListView: RecyclerView
    private lateinit var recipeListAdapter: RecipeListAdapter

    init {
        presenter.view = this
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_list_fragment)

        recipeListView = findViewById(R.id.recipe_list_view)
        val router by inject<RecipeListContract.Router>()
        recipeListAdapter = RecipeListAdapter(router)
        val layoutManager = LinearLayoutManager(this)
        recipeListView.layoutManager = layoutManager
        recipeListView.addItemDecoration(DividerItemDecoration(this,
                layoutManager.orientation))
        recipeListView.adapter = recipeListAdapter

        presenter.start()
    }

    override fun setRecipes(recipes: List<Recipe>) {
        recipeListAdapter.list.clear()
        recipeListAdapter.list.addAll(recipes)
        recipeListAdapter.notifyDataSetChanged()
    }
}