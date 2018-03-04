package zakharvoit.com.foodhackapp.recipedetail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.databinding.RecipeDetailActivityBinding
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
            val ingredientsList = findViewById<RecyclerView>(R.id.detail_ingredients_list)
            val layout = LinearLayoutManager(this)
            ingredientsList.layoutManager = layout
            val ingredientsAdapter = IngredientListAdapter(recipe.ingredients.map { i -> i.title })
            ingredientsList.adapter = ingredientsAdapter
        }();

        {
            val stepList = findViewById<RecyclerView>(R.id.detail_step_list)
            val layout = LinearLayoutManager(this)
            stepList.layoutManager = layout
            val adapter = StepListAdapter(recipe.steps)
            stepList.adapter = adapter
        }();


        {
            val proteinList = findViewById<RecyclerView>(R.id.titles_list)
            val layout = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            proteinList.layoutManager = layout
            val adapter = EnergyListAdapter(listOf("Калории", "Белки", "Жиры", "Углеводы"))
            proteinList.addItemDecoration(DividerItemDecoration(this,
                    layout.orientation))

            proteinList.adapter = adapter
        }();

        {
            val fatList = findViewById<RecyclerView>(R.id.values_list)
            val layout = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            fatList.layoutManager = layout
            val adapter = EnergyListAdapter(listOf(
                    recipe.energyValue.calories.toString(),
                    recipe.energyValue.protein.toString(),
                    recipe.energyValue.fats.toString(),
                    recipe.energyValue.carbs.toString()))
            fatList.addItemDecoration(DividerItemDecoration(this,
                    layout.orientation))

            fatList.adapter = adapter
        }();
    }
}