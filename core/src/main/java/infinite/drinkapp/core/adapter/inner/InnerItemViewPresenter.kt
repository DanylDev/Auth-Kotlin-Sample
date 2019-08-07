package infinite.drinkapp.core.adapter.inner

interface InnerItemViewPresenter<V> {
    fun present(elementView: V, parentPosition: Int, position: Int)
}