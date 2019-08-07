package infinite.drinkapp.app.scene

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import infinite.drinkapp.app.R
import infinite.drinkapp.app.scene.auth.authorizationIntent
import infinite.drinkapp.core.anatation.ActivityLayout

@ActivityLayout(R.layout.activity_splash)
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            startActivity(authorizationIntent())
            supportFinishAfterTransition()
        }, 1000)
    }
}
