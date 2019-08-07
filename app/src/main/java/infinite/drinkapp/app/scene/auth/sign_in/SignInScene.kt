package infinite.drinkapp.app.scene.auth.sign_in

import infinite.drinkapp.core.presentation.*

interface SignInScene {

    // region View
    interface View : Presentable<View, Presenter>, ProgressPresentable,
            KeyboardPresentable, AlertPresentable {

    }
    // endregion

    // region Presenter
    interface Presenter : GenericPresenter<View> {
        fun login(email: String, password: String)

    }
    //endregion

}