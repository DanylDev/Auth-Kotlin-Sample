package infinite.drinkapp.core.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.util.Log
import infinite.drinkapp.core.presentation.ItemView
import infinite.drinkapp.core.adapter.ItemViewPresenter

abstract class PresenterAdapterDelegate<V : ItemView, H : RecyclerView.ViewHolder>(
        override val viewType: ViewType?,
        private val presenter: ItemViewPresenter<V>
) : AdapterDelegate<H> {

    override fun onBindTypedViewHolder(position: Int, holder: H) {
        @Suppress("UNCHECKED_CAST")
        val view = holder as? V
        if (view != null) {
            Log.d(PresenterAdapterDelegate::class.java.simpleName, holder.itemViewType.toString())
            holder.setIsRecyclable(false)
            presenter.present(view, position)
        }
    }
}