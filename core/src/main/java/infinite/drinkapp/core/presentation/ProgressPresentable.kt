package infinite.drinkapp.core.presentation

import android.support.v4.app.Fragment

interface ProgressPresentable {
    fun showProgress()
    fun hideProgress()
    fun replaceFragment(containerViewId: Int, fragment: Fragment, addToBackStack: Boolean)
    fun cleaBackStack()
}