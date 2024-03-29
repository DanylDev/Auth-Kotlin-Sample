package infinite.drinkapp.core.adapter.inner.delegate

import android.support.v7.widget.RecyclerView
import infinite.drinkapp.core.adapter.delegate.ViewType
import infinite.drinkapp.core.adapter.inner.InnerItemViewPresenter

abstract class PresenterInnerAdapterDelegate<V, H>(
        override val viewType: ViewType?,
        private val presenter: InnerItemViewPresenter<V>
) : InnerAdapterDelegate<H> where H : RecyclerView.ViewHolder {
    override fun onBindTypedViewHolder(parentPosition: Int, position: Int, holder: H) {
        @Suppress("UNCHECKED_CAST")
        presenter.present(holder as? V ?: return, parentPosition, position)
    }
}