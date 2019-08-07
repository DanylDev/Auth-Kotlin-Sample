package infinite.drinkapp.app.di.module

import infinite.drinkapp.app.di.provider.ApiProvider
import infinite.drinkapp.app.api.DrinkApi
import toothpick.config.Module

class ApiModule : Module() {
    init {
        bind(DrinkApi::class.java)
                .toProvider(ApiProvider::class.java)
                .providesSingletonInScope()
    }

}