package zakharvoit.com.foodhackapp

interface BasePresenter<T> {
    var view: T

    fun start()
}

