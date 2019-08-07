package infinite.drinkapp.core.app

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import infinite.drinkapp.core.presentation.Presentable

class PresentableFragmentLifecycleCallbacks : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentActivityCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
        if (f is Presentable<*, *>) {
            f.presenter.start()
        }
    }

    override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
        if (f is Presentable<*, *>) {
            f.presenter.stop()
        }
    }

}