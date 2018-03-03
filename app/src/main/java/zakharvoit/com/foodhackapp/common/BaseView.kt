package zakharvoit.com.foodhackapp.common

interface BaseView<out T : BasePresenter<*>> {
    val presenter: T
}
