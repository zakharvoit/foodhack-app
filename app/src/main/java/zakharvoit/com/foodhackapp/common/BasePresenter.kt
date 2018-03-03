package zakharvoit.com.foodhackapp.common

interface BasePresenter<T> {
    var view: T

    fun start()
}

