package zakharvoit.com.foodhackapp.ingredientchoose

import org.koin.dsl.module.applicationContext
import zakharvoit.com.foodhackapp.api.createFoodhackApi

val ingredientChooseModule = applicationContext {
    provide { IngredientChooseFragment() as IngredientChooseContract.View }
    provide { IngredientChooseInteractor(get()) as IngredientChooseContract.Interactor }
    provide { IngredientChoosePresenter(get(), get()) as IngredientChooseContract.Presenter }
}