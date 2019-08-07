package infinite.drinkapp.app.di.module

import android.content.Context
import infinite.drinkapp.core.resource.ResourceManager
import infinite.drinkapp.app.account.AccountManager
import infinite.drinkapp.app.coroutines.AppExecutor
import infinite.drinkapp.app.coroutines.Executor
import infinite.drinkapp.app.resource.AppResourceManager
import toothpick.config.Module


class AppModule(context: Context) : Module() {
    init {
        bind(Context::class.java).toInstance(context)
        bind(ResourceManager::class.java).to(AppResourceManager::class.java).singletonInScope()
        bind(Executor::class.java).toInstance(AppExecutor())
        bind(AccountManager::class.java).to(AccountManager::class.java).singletonInScope()
    }
}