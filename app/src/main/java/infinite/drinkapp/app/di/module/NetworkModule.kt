package infinite.drinkapp.app.di.module

import infinite.drinkapp.app.di.provider.OkHttpClientProvider
import infinite.drinkapp.app.di.provider.RetrofitProvider
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import toothpick.config.Module

class NetworkModule : Module() {
    init {
        bind(OkHttpClient::class.java)
                .toProvider(OkHttpClientProvider::class.java)
                .providesSingletonInScope()
        bind(Retrofit::class.java)
                .toProvider(RetrofitProvider::class.java)
                .providesSingletonInScope()
    }
}