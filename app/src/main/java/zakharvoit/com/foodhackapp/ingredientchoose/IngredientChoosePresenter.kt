package zakharvoit.com.foodhackapp.ingredientchoose

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class IngredientChoosePresenter(private val interactor: IngredientChooseContract.Interactor) :
        IngredientChooseContract.Presenter {

    override lateinit var view: IngredientChooseContract.View

    override fun start() {
        interactor.getRandomIngredients()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                { ingredients ->
                    view.setIngredients(ingredients)
                },
                { throwable ->
                    view.onError(throwable.localizedMessage)
                })
    }
}