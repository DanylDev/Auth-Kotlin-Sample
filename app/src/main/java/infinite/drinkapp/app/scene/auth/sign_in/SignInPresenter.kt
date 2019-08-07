package infinite.drinkapp.app.scene.auth.sign_in

import infinite.drinkapp.app.account.AccountManager
import infinite.drinkapp.app.api.DrinkApi
import infinite.drinkapp.app.coroutines.Executor
import infinite.drinkapp.app.presentation.CoroutinesViewPresenter
import javax.inject.Inject

class SignInPresenter @Inject constructor(
        view: SignInScene.View,
        private val executor: Executor,
        private val api: DrinkApi,
        private val accountManager: AccountManager
) : CoroutinesViewPresenter<SignInScene.View>(view), SignInScene.Presenter {

    override fun login(email: String, password: String) {

    }
}