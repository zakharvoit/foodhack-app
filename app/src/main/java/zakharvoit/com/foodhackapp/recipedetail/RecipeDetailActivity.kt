package zakharvoit.com.foodhackapp.recipedetail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.TextView
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.databinding.RecipeDetailActivityBinding
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.Recipe

class RecipeDetailActivity : AppCompatActivity() {
    private val viewModel = RecipeDetailViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: RecipeDetailActivityBinding = DataBindingUtil.inflate(
                LayoutInflater.from(this), R.layout.recipe_detail_activity,
                null, false)

        val recipe = intent.getParcelableExtra<Recipe>("recipe")
        viewModel.recipeInfo = recipe
        binding.viewModel = viewModel
        setContentView(binding.root);

        {
            val ingredientsList = findViewById<TextView>(R.id.detail_ingredients_list)
            ingredientsList.text = recipe.ingredients.map(Ingredient::title)
                    .joinToString(separator = ", ") + "."
        }();

        {
            val stepList = findViewById<RecyclerView>(R.id.detail_step_list)
            val layout = LinearLayoutManager(this)
            stepList.layoutManager = layout
            val adapter = StepListAdapter(recipe.steps)
            stepList.isNestedScrollingEnabled = false
            stepList.adapter = adapter
        }();


        {
            val proteinList = findViewById<RecyclerView>(R.id.titles_list)
            val layout = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            proteinList.layoutManager = layout
            val adapter = EnergyListAdapter(false, listOf("Калории", "Белки", "Жиры", "Углеводы"))
            proteinList.addItemDecoration(DividerItemDecoration(this,
                    layout.orientation))

            proteinList.isNestedScrollingEnabled = false
            proteinList.adapter = adapter
        }();

        {
            val fatList = findViewById<RecyclerView>(R.id.values_list)
            val layout = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            fatList.layoutManager = layout
            val adapter = EnergyListAdapter(true, listOf(
                    recipe.energyValue.calories.toString(),
                    recipe.energyValue.protein.toString(),
                    recipe.energyValue.fats.toString(),
                    recipe.energyValue.carbs.toString()))
            fatList.addItemDecoration(DividerItemDecoration(this,
                    layout.orientation))

            fatList.isNestedScrollingEnabled = false
            fatList.adapter = adapter
        }();
    }
}