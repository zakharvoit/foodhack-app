package zakharvoit.com.foodhackapp.recipelist

import org.koin.dsl.module.applicationContext

val recipeListModule = applicationContext {
    provide { RecipeListActivity() as RecipeListContract.View }
    provide { RecipeListInteractor(get()) as RecipeListContract.Interactor }
    provide { RecipeListPresenter(get()) as RecipeListContract.Presenter }
    provide { RecipeListRouter(get(), get(), get()) as RecipeListContract.Router }
}

