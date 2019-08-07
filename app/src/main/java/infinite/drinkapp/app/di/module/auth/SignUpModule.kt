package infinite.drinkapp.app.di.module.auth

import infinite.drinkapp.app.scene.auth.sign_up.SignUpFragment
import infinite.drinkapp.app.scene.auth.sign_up.SignUpPresenter
import infinite.drinkapp.app.scene.auth.sign_up.SignUpScene
import toothpick.config.Module

class SignUpModule(fragment: SignUpFragment) : Module() {

    init {
        bind(SignUpScene.View::class.java).toInstance(fragment)
        bind(SignUpScene.Presenter::class.java).to(SignUpPresenter::class.java)
                .singletonInScope()
    }

}
