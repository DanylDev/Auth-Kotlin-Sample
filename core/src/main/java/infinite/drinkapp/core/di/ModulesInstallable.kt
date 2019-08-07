package infinite.drinkapp.core.di

import toothpick.Scope

interface ModulesInstallable {
    fun installModules(scope: Scope) = Unit
}