package zakharvoit.com.foodhackapp.ingredientchoose

import org.koin.dsl.module.applicationContext
import zakharvoit.com.foodhackapp.ingredientchoose.api.createIngredientsApi

val ingredientChooseModule = applicationContext {
    provide { IngredientChooseFragment() as IngredientChooseContract.View }
    provide { IngredientChooseInteractor(get()) as IngredientChooseContract.Interactor }
    provide { IngredientChoosePresenter(get()) as IngredientChooseContract.Presenter }
    provide { createIngredientsApi() }
}