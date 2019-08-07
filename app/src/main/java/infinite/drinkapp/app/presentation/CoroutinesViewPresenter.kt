package infinite.drinkapp.app.presentation

import android.support.annotation.CallSuper
import infinite.drinkapp.core.presentation.ViewPresenter
import kotlinx.coroutines.Job

abstract class CoroutinesViewPresenter<out V>(view: V) : ViewPresenter<V>(view) {

    // region Control job
    private lateinit var job: Job

    @CallSuper
    override fun start() {
        job = Job()
        super.start()
    }

    @CallSuper
    override fun stop() {
        job.cancel()
        super.stop()
    }
    // endregion
}