package infinite.drinkapp.core.adapter.inner.delegate

import infinite.drinkapp.core.adapter.delegate.ViewType


interface InnerViewTypeManager {
    fun getItemViewType(parentPosition: Int, position: Int): ViewType
}