package zakharvoit.com.foodhackapp.recipelist

import android.os.Bundle
import android.support.v4.app.Fragment
import org.koin.android.ext.android.inject
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.common.BaseActivity

class RecipeListActivity : BaseActivity() {
    override val fragmentContainer: Int = R.id.recipe_list_fragment_container
    private val recipeListFragment by inject<RecipeListContract.View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_list_activity)

        addToBackStack(recipeListFragment as Fragment, "recipe_list")
    }
}