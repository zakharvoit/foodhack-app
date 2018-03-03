package zakharvoit.com.foodhackapp.ingredientchoose

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.koin.android.ext.android.inject
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.databinding.IngredientChooseFragmentBinding
import zakharvoit.com.foodhackapp.model.Ingredient

class IngredientChooseFragment : Fragment(), IngredientChooseContract.View {
    override val presenter by inject<IngredientChooseContract.Presenter>()
    private val viewModel = IngredientChooseViewModel()

    init {
        presenter.view = this
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding: IngredientChooseFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.ingredient_choose_fragment, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.start()
    }

    override fun setIngredient(ingredient: Ingredient) {
        viewModel.isLoading = false
        viewModel.ingredient = ingredient
    }

    override fun onError(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}