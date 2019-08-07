package infinite.drinkapp.app.di.module.auth

import infinite.drinkapp.app.scene.auth.sign_in.SignInFragment
import infinite.drinkapp.app.scene.auth.sign_in.SignInPresenter
import infinite.drinkapp.app.scene.auth.sign_in.SignInScene
import toothpick.config.Module

class SignInModule(fragment: SignInFragment) : Module() {

    init {
        bind(SignInScene.View::class.java).toInstance(fragment)
        bind(SignInScene.Presenter::class.java).to(SignInPresenter::class.java)
                .singletonInScope()
    }

}
