package infinite.drinkapp.app.api

import infinite.drinkapp.app.constants.Constants.CONFIRM_PASSWORD
import infinite.drinkapp.app.constants.Constants.EMAIL
import infinite.drinkapp.app.constants.Constants.FIRST_NAME
import infinite.drinkapp.app.constants.Constants.LAST_NAME
import infinite.drinkapp.app.constants.Constants.LOGIN
import infinite.drinkapp.app.constants.Constants.PASSWORD
import infinite.drinkapp.app.constants.Constants.REGISTER
import infinite.drinkapp.app.model.AuthResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface DrinkApi {

    @FormUrlEncoded
    @POST(REGISTER)
    fun registerNewUser(@Field(FIRST_NAME) firstName: String,
                        @Field(LAST_NAME) lastName: String,
                        @Field(EMAIL) email: String,
                        @Field(PASSWORD) password: String,
                        @Field(CONFIRM_PASSWORD) confirmPassword: String): Deferred<AuthResponse>

    @FormUrlEncoded
    @POST(LOGIN)
    fun loginUser(@Field(EMAIL) email: String,
                  @Field(PASSWORD) password: String): Deferred<AuthResponse>

}