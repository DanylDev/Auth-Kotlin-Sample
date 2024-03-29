package infinite.drinkapp.core.presentation

interface GenericPresenter<out V> {
    val view: V?

    fun start()

    fun stop()

}