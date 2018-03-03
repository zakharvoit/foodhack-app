package zakharvoit.com.foodhackapp

interface BaseView<out T : BasePresenter<*>> {
    val presenter: T
}
