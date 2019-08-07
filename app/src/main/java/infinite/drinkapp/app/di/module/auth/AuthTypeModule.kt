package infinite.drinkapp.app.di.module.auth

import infinite.drinkapp.app.scene.auth.auth_type.AuthTypeFragment
import infinite.drinkapp.app.scene.auth.auth_type.AuthTypePresenter
import infinite.drinkapp.app.scene.auth.auth_type.AuthTypeScene
import toothpick.config.Module

class AuthTypeModule(fragment: AuthTypeFragment) : Module() {

    init {
        bind(AuthTypeScene.View::class.java).toInstance(fragment)
        bind(AuthTypeScene.Presenter::class.java).to(AuthTypePresenter::class.java)
                .singletonInScope()
    }

}
