package zakharvoit.com.foodhackapp.ingredientchoose

import org.koin.dsl.module.applicationContext

val ingredientChooseModule = applicationContext {
    provide { IngredientChooseFragment() as IngredientChooseContract.View }
    provide { IngredientChooseMockInteractor() as IngredientChooseContract.Interactor }
    provide { IngredientChoosePresenter(get()) as IngredientChooseContract.Presenter }
}