package infinite.drinkapp.core.app

import android.app.Activity
import android.os.Bundle
import infinite.drinkapp.core.anatation.ActivityLayout
import infinite.drinkapp.core.extension.getAnnotationOrNull

class LayoutActivityLifecycleCallbacks : AbsActivityLifecycleCallbacks() {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        val activityLayout = activity::class.java.getAnnotationOrNull(ActivityLayout::class.java)
        if (activityLayout != null) {
            activity.setContentView(activityLayout.layoutId)
        }
    }
}