package infinite.drinkapp.app.di.provider

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import infinite.drinkapp.app.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

class RetrofitProvider @Inject constructor(
        private val client: OkHttpClient
) : Provider<Retrofit> {
    override fun get(): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_SERVER_URL)
            .client(client)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}