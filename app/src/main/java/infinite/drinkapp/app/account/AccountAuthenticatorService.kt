package infinite.drinkapp.app.account

import android.accounts.AbstractAccountAuthenticator
import android.app.Service
import android.content.Intent
import android.os.IBinder
import infinite.drinkapp.app.account.AccountAuthenticator

class AccountAuthenticatorService : Service() {
    private lateinit var authenticator: AbstractAccountAuthenticator

    override fun onCreate() {
        super.onCreate()
        authenticator = AccountAuthenticator(this)
    }

    override fun onBind(intent: Intent?): IBinder = authenticator.iBinder
}