package infinite.drinkapp.core.adapter.holder

interface ParentViewHolder {
    val parentAdapterPosition: Int

    fun update()

    fun scrollToTopPosition()
}