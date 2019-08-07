package infinite.drinkapp.app.scene.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import infinite.drinkapp.app.R
import infinite.drinkapp.app.scene.auth.auth_type.AuthTypeFragment
import infinite.drinkapp.core.di.ModulesInstallable
import kotlinx.android.synthetic.main.activity_auth.*

fun Context.authorizationIntent(): Intent {
    return Intent(this, AuthActivity::class.java)
}

class AuthActivity : AppCompatActivity(), ModulesInstallable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val fragment = supportFragmentManager.findFragmentById(authFrame.id)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                    .add(authFrame.id, AuthTypeFragment())
                    .commit()
        }
    }
}
