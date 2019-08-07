package infinite.drinkapp.app.scene.auth.auth_type

import infinite.drinkapp.app.account.AccountManager
import infinite.drinkapp.app.api.DrinkApi
import infinite.drinkapp.app.coroutines.Executor
import infinite.drinkapp.app.presentation.CoroutinesViewPresenter
import javax.inject.Inject

class AuthTypePresenter @Inject constructor(
        view: AuthTypeScene.View,
        private val executor: Executor,
        private val api: DrinkApi,
        private val accountManager: AccountManager
) : CoroutinesViewPresenter<AuthTypeScene.View>(view), AuthTypeScene.Presenter {

}