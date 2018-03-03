package zakharvoit.com.foodhackapp

import android.os.Bundle
import android.support.v4.app.Fragment
import org.koin.android.ext.android.inject
import zakharvoit.com.foodhackapp.ingredientchoose.IngredientChooseContract

class MainActivity : BaseActivity() {
    private val ingredientChooseView by inject<IngredientChooseContract.View>()
    override val fragmentContainer = R.id.fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addToBackStack(ingredientChooseView as Fragment, "choose_ingredients")
    }
}
