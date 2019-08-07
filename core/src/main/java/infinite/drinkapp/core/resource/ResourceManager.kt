package infinite.drinkapp.core.resource

import android.support.annotation.StringRes

interface ResourceManager {
    fun string(@StringRes resId: Int): String
}