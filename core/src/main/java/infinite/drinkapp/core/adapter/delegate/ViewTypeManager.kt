package infinite.drinkapp.core.adapter.delegate

interface ViewTypeManager {
    fun getItemViewType(position: Int): ViewType
}