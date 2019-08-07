package infinite.drinkapp.app

import android.app.Application
import infinite.drinkapp.app.di.module.AppModule
import infinite.drinkapp.app.di.module.NetworkModule
import infinite.drinkapp.core.app.LayoutActivityLifecycleCallbacks
import infinite.drinkapp.core.app.PresentableActivityLifecycleCallbacks
import infinite.drinkapp.core.app.ScopeActivityLifecycleCallbacks
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

class App : Application() {

    // region Lifecycle
    override fun onCreate() {
        super.onCreate()

        val configuration = if (BuildConfig.DEBUG) {
            Configuration.forDevelopment().preventMultipleRootScopes()
        } else {

            FactoryRegistryLocator.setRootRegistry(FactoryRegistry())
            MemberInjectorRegistryLocator.setRootRegistry(MemberInjectorRegistry())
            Configuration.forProduction().disableReflection()
        }

        Toothpick.setConfiguration(configuration)

        Toothpick.openScope(this).installModules(
                AppModule(this), NetworkModule()
        )

        registerActivityLifecycleCallbacks(ScopeActivityLifecycleCallbacks())
        registerActivityLifecycleCallbacks(PresentableActivityLifecycleCallbacks())
        registerActivityLifecycleCallbacks(LayoutActivityLifecycleCallbacks())
    }
    // endregion
}