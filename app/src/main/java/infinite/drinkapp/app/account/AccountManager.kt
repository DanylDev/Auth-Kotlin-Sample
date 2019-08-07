package infinite.drinkapp.app.account

import android.content.Context
import android.os.*
import android.support.annotation.RequiresApi
import android.util.Base64
import javax.inject.Inject

private const val TOKEN_KEY = "token"
private const val RADIUS = "radius"
private const val FIBRE = "fibre"
private const val BANDWIDTH = "bandwidth"

class AccountManager @Inject constructor(
        context: Context
) {
    private val manager = android.accounts.AccountManager.get(context)
    private val handler = Handler(
            HandlerThread(
                    AccountManager::class.java.simpleName,
                    Process.THREAD_PRIORITY_BACKGROUND
            ).apply {
                start()
            }.looper
    )

    private var _account: Account? = null
    val current: Account?
        get() {
            val accounts = manager.getAccountsByType(AccountAuthenticator.ACCOUNT_TYPE)
            val appAccount = accounts.lastOrNull() ?: return _account

            val email = appAccount.name
            val password = manager.getPassword(appAccount)

            val current = Account(email, password)
            if (current != _account) {
                _account = current

                return current
            }

            return _account
        }

    fun addAccount(account: Account, token: String) {
        val bundle = Bundle()
        bundle.putString(TOKEN_KEY, token)
        manager.addAccountExplicitly(account.androidAccount, account.password, bundle)
    }

    fun setRadius(radius: String) = manager.getAccountsByType(AccountAuthenticator.ACCOUNT_TYPE).firstOrNull()?.let {
        manager.setUserData(it, RADIUS, radius)
    }

    fun getRadius(): String? = manager.getAccountsByType(AccountAuthenticator.ACCOUNT_TYPE).firstOrNull()?.let {
        manager.getUserData(it, RADIUS)
    }

    fun getToken(): String? = manager.getAccountsByType(AccountAuthenticator.ACCOUNT_TYPE).firstOrNull()?.let {
        manager.getUserData(it, TOKEN_KEY)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    fun removeAccount() {
        val account = current?.androidAccount ?: return
        if (manager.removeAccountExplicitly(account)) {
            _account = null
        } else {
            @Suppress("DEPRECATION")
            manager.removeAccount(account, {
                try {
                    if (it.result) {
                        _account = null
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }, handler)
        }
    }

    fun setFibre(fibre: String)  = manager.getAccountsByType(AccountAuthenticator.ACCOUNT_TYPE).firstOrNull()?.let {
        manager.setUserData(it, FIBRE, fibre)
    }

    fun getFibre(): String? = manager.getAccountsByType(AccountAuthenticator.ACCOUNT_TYPE).firstOrNull()?.let {
        manager.getUserData(it, FIBRE)
    }

    fun setBandwidth(bandwidth: String)  = manager.getAccountsByType(AccountAuthenticator.ACCOUNT_TYPE).firstOrNull()?.let {
        manager.setUserData(it, BANDWIDTH, bandwidth)
    }

    fun getBandwidth(): String? = manager.getAccountsByType(AccountAuthenticator.ACCOUNT_TYPE).firstOrNull()?.let {
        manager.getUserData(it, BANDWIDTH)
    }
}

private val Account.androidAccount get() = android.accounts.Account(userName, AccountAuthenticator.ACCOUNT_TYPE)