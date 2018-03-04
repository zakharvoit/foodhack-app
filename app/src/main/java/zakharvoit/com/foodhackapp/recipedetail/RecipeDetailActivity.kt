package zakharvoit.com.foodhackapp.recipedetail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.common.BaseActivity
import zakharvoit.com.foodhackapp.databinding.RecipeDetailActivityBinding

class RecipeDetailActivity : AppCompatActivity() {
    private val viewModel = RecipeDetailViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: RecipeDetailActivityBinding = DataBindingUtil.inflate(
                LayoutInflater.from(this), R.layout.recipe_detail_activity,
                null, false)
        binding.viewModel = viewModel
        setContentView(binding.root)
    }
}