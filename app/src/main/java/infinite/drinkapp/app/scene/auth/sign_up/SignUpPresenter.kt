package infinite.drinkapp.app.scene.auth.sign_up

import infinite.drinkapp.app.account.AccountManager
import infinite.drinkapp.app.api.DrinkApi
import infinite.drinkapp.app.coroutines.Executor
import infinite.drinkapp.app.extension.launchSilent
import infinite.drinkapp.app.presentation.CoroutinesViewPresenter
import javax.inject.Inject

class SignUpPresenter @Inject constructor(
        view: SignUpScene.View,
        private val executor: Executor,
        private val api: DrinkApi,
        private val accountManager: AccountManager
) : CoroutinesViewPresenter<SignUpScene.View>(view), SignUpScene.Presenter {

    override fun registerUser(name: String, email: String, password: String) {
        launchSilent(executor.ui) {
            try {
                api.registerNewUser(firstName = name.split(" ")[0],
                        lastName = name.split(" ")[1],
                        email = email,
                        password = password,
                        confirmPassword = password).await()
                view?.registrationSuccess()
            } catch (e: Exception) {
                view?.showError()
            }
        }
    }
}