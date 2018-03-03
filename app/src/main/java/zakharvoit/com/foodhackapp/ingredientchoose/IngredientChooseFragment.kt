package zakharvoit.com.foodhackapp.ingredientchoose

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yuyakaido.android.cardstackview.CardStackView
import com.yuyakaido.android.cardstackview.SwipeDirection
import org.koin.android.ext.android.inject
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.databinding.IngredientChooseFragmentBinding
import zakharvoit.com.foodhackapp.ingredientchoose.IngredientChooseContract
import zakharvoit.com.foodhackapp.ingredientchoose.IngredientsAdapter
import zakharvoit.com.foodhackapp.model.Ingredient
import zakharvoit.com.foodhackapp.model.IngredientChooseOption

class IngredientChooseFragment : Fragment(), IngredientChooseContract.View, CardStackView.CardEventListener {
    override val presenter by inject<IngredientChooseContract.Presenter>()
    private lateinit var ingredientView: CardStackView
    private lateinit var ingredientViewAdapter: IngredientsAdapter

    init {
        presenter.view = this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding: IngredientChooseFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.ingredient_choose_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ingredientView = view.findViewById(R.id.ingredient_item_card_stack)
        ingredientViewAdapter = IngredientsAdapter(context!!)
        ingredientView.setAdapter(ingredientViewAdapter)
        ingredientView.setCardEventListener(this)
        presenter.start()
    }

    override fun setIngredients(ingredients: List<Ingredient>) {
        ingredientViewAdapter.addAll(ingredients)
    }

    override fun onError(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun onCardDragging(percentX: Float, percentY: Float) {
    }

    override fun onCardSwiped(direction: SwipeDirection?) {
        val ingredient = ingredientViewAdapter[0]
        ingredientViewAdapter.remove(ingredient)
        val option = when (direction) {
            SwipeDirection.Left -> IngredientChooseOption.SKIP
            SwipeDirection.Right -> IngredientChooseOption.GOOD
            SwipeDirection.Bottom -> IngredientChooseOption.BAD
            else -> TODO()
        }
        presenter.onIngredientSwiped(ingredient,option)
    }

    override fun onCardReversed() {
    }

    override fun onCardMovedToOrigin() {
    }

    override fun onCardClicked(index: Int) {
    }
}