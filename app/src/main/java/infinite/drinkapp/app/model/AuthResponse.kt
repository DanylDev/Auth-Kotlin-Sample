package infinite.drinkapp.app.model

import com.google.gson.annotations.SerializedName

data class AuthResponse(

        @SerializedName("result")
        val result: String? = null
)