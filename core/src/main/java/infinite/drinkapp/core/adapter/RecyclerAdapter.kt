package infinite.drinkapp.core.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import infinite.drinkapp.core.extension.weak
import infinite.drinkapp.core.adapter.delegate.AdapterDelegate
import infinite.drinkapp.core.adapter.delegate.ViewType
import infinite.drinkapp.core.adapter.delegate.ViewTypeManager

open class RecyclerAdapter<T>(
        provider: DataProvider<T>,
        viewTypeManager: ViewTypeManager? = null,
        private vararg val delegates: AdapterDelegate<*>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val provider = provider.weak()
    private val viewTypeManager = viewTypeManager?.weak()

    private fun delegateAtIndex(index: Int) = delegates.elementAtOrNull(index)

    private fun delegateIndexForType(viewType: ViewType) =
            delegates.indexOfFirst { it.viewType == viewType }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            delegateAtIndex(viewType)?.onCreateViewHolder(parent)
                    ?: throw IllegalArgumentException("No AdapterDelegates registered for view type: $viewType.")

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAtIndex(getItemViewType(position))?.apply {
            onBindViewHolder(position, holder)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val viewType = viewTypeManager?.get()?.getItemViewType(position)
        if (viewType != null) {
            return delegateIndexForType(viewType)
        }
        if (delegates.size == 1) {
            return 0
        }
        throw IllegalArgumentException("No AdapterDelegates registered for item view at position: $position.")
    }

    override fun getItemCount() = provider.get()?.itemCount ?: 0
}