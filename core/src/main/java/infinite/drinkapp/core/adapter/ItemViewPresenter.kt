package infinite.drinkapp.core.adapter

import infinite.drinkapp.core.presentation.ItemView


interface ItemViewPresenter<V : ItemView> {
    fun present(view: V, position: Int)
}