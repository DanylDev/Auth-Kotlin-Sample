package infinite.drinkapp.app.scene.auth.sign_up

import infinite.drinkapp.core.presentation.*

interface SignUpScene {

    // region View
    interface View : Presentable<View, Presenter>, ProgressPresentable,
            KeyboardPresentable, AlertPresentable {
        fun registrationSuccess()
        fun showError()
    }
    // endregion

    // region Presenter
    interface Presenter : GenericPresenter<View> {
        fun registerUser(name: String, email: String, password: String)
    }
    //endregion

}