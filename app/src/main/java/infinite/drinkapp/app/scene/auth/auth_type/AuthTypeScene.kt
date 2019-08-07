package infinite.drinkapp.app.scene.auth.auth_type

import infinite.drinkapp.core.presentation.*

interface AuthTypeScene {

    // region View
    interface View : Presentable<View, Presenter>, ProgressPresentable,
            KeyboardPresentable, AlertPresentable {

    }
    // endregion

    // region Presenter
    interface Presenter : GenericPresenter<View> {

    }
    //endregion

}