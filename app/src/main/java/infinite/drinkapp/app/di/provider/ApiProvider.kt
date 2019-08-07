package infinite.drinkapp.app.di.provider

import infinite.drinkapp.app.api.DrinkApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Provider


class ApiProvider @Inject constructor(
        private val retrofit: Retrofit
) : Provider<DrinkApi> {
    override fun get(): DrinkApi = retrofit.create(DrinkApi::class.java)
}