package infinite.drinkapp.app.account

import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.accounts.AccountManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import infinite.drinkapp.app.scene.auth.AuthActivity
import infinite.drinkapp.app.BuildConfig


class AccountAuthenticator(private val context: Context) : AbstractAccountAuthenticator(context) {
    companion object {
        const val ACCOUNT_TYPE = BuildConfig.APPLICATION_ID + ".main"
        const val TOKEN_TYPE = BuildConfig.APPLICATION_ID

        private const val KEY_TOKEN_TYPE = "KEY_TOKEN_TYPE"
    }

    override fun addAccount(
            response: AccountAuthenticatorResponse?,
            accountType: String?,
            authTokenType: String?,
            requiredFeatures: Array<out String>?,
            options: Bundle?
    ) = Bundle().apply {
        if (AccountManager.get(context).getAccountsByType(ACCOUNT_TYPE).isEmpty()) {
            val intent = Intent(context, AuthActivity::class.java)
            intent.putExtra(KEY_TOKEN_TYPE, TOKEN_TYPE)
            intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response)

            putParcelable(AccountManager.KEY_INTENT, intent)
        }
    }

    override fun hasFeatures(
            response: AccountAuthenticatorResponse?,
            account: Account?,
            features: Array<out String>?
    ) = Bundle(1).apply {
        putBoolean(AccountManager.KEY_BOOLEAN_RESULT, false)
    }

    override fun getAuthTokenLabel(authTokenType: String?) = null
    override fun confirmCredentials(
            response: AccountAuthenticatorResponse?,
            account: Account?,
            options: Bundle?
    ) = null

    override fun updateCredentials(
            response: AccountAuthenticatorResponse?,
            account: Account?,
            authTokenType: String?,
            options: Bundle?
    ) = null

    override fun getAuthToken(
            response: AccountAuthenticatorResponse?,
            account: Account?,
            authTokenType: String?,
            options: Bundle?
    ) = null

    override fun editProperties(
            response: AccountAuthenticatorResponse?,
            accountType: String?
    ) = null

}