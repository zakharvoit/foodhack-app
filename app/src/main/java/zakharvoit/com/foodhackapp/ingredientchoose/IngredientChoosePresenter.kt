package zakharvoit.com.foodhackapp.ingredientchoose

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class IngredientChoosePresenter(private val interactor: IngredientChooseContract.Interactor) :
        IngredientChooseContract.Presenter {

    override lateinit var view: IngredientChooseContract.View

    override fun start() {
        interactor.getNewRandomIngredient()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                { ingredient ->
                    view.setIngredient(ingredient)
                },
                { throwable ->
                    view.onError(throwable.localizedMessage)
                })
    }
}