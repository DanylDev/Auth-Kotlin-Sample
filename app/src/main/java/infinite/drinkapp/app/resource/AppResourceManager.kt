package infinite.drinkapp.app.resource

import android.content.Context
import infinite.drinkapp.core.extension.weak
import infinite.drinkapp.core.resource.ResourceManager
import javax.inject.Inject

class AppResourceManager @Inject constructor(context: Context) :
        ResourceManager {
    private val reference = context.applicationContext.weak()

    private fun requireContext(): Context {
        return reference.get() ?: throw IllegalStateException("Context not present")
    }

    override fun string(resId: Int): String = requireContext().getString(resId)
}