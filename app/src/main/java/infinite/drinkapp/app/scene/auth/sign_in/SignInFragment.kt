package infinite.drinkapp.app.scene.auth.sign_in


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import infinite.drinkapp.app.R
import infinite.drinkapp.app.di.module.ApiModule
import infinite.drinkapp.app.di.module.auth.SignInModule
import infinite.drinkapp.core.di.ModulesInstallable
import infinite.drinkapp.core.fragment.BaseFragment
import infinite.drinkapp.core.presentation.Presentable
import kotlinx.android.synthetic.main.fragment_sign_in.*
import toothpick.Scope
import javax.inject.Inject

class SignInFragment : BaseFragment(), Presentable<SignInScene.View, SignInScene.Presenter>,
        ModulesInstallable, SignInScene.View, View.OnClickListener {

    @Inject
    override lateinit var presenter: SignInScene.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_sign_in, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backBtn.setOnClickListener(this)
        loginBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) =
            when (v) {
                backBtn -> requireFragmentManager().popBackStack()
                loginBtn ->
                    if (userEmail.text.isNotEmpty() && !userPassword.text.isNullOrEmpty()) {
                        presenter.login(userEmail.text.toString(), userPassword.text.toString())
                    } else {

                    }
                else -> Unit
            }

    override fun installModules(scope: Scope) {
        scope.installModules(ApiModule(), SignInModule(this))
    }

}
