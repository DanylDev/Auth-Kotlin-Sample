package infinite.drinkapp.app.scene.auth.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import infinite.drinkapp.app.R
import infinite.drinkapp.app.di.module.ApiModule
import infinite.drinkapp.app.di.module.auth.SignUpModule
import infinite.drinkapp.core.di.ModulesInstallable
import infinite.drinkapp.core.fragment.BaseFragment
import infinite.drinkapp.core.presentation.Presentable
import kotlinx.android.synthetic.main.fragment_sign_up.*
import toothpick.Scope
import javax.inject.Inject

class SignUpFragment : BaseFragment(), Presentable<SignUpScene.View, SignUpScene.Presenter>,
        ModulesInstallable, SignUpScene.View, View.OnClickListener {

    @Inject
    override lateinit var presenter: SignUpScene.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_sign_up, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backBtn.setOnClickListener(this)
        registerBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) =
            when (v) {
                backBtn -> requireFragmentManager().popBackStack()
                registerBtn ->
                    if (userEmail.text.isNotEmpty()
                            && userName.text.isNotEmpty()
                            && !userPassword.text.isNullOrEmpty()) {
                        presenter.registerUser(
                                userName.text.toString(),
                                userEmail.text.toString(),
                                userPassword.text.toString()
                        )
                    } else {

                    }
                else -> Unit
            }

    override fun registrationSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun installModules(scope: Scope) {
        scope.installModules(ApiModule(), SignUpModule(this))
    }

}
