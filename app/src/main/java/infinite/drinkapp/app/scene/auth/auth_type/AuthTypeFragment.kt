package infinite.drinkapp.app.scene.auth.auth_type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import infinite.drinkapp.app.R
import infinite.drinkapp.app.di.module.ApiModule
import infinite.drinkapp.app.di.module.auth.AuthTypeModule
import infinite.drinkapp.app.scene.auth.sign_in.SignInFragment
import infinite.drinkapp.app.scene.auth.sign_up.SignUpFragment
import infinite.drinkapp.core.di.ModulesInstallable
import infinite.drinkapp.core.fragment.BaseFragment
import infinite.drinkapp.core.presentation.Presentable
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.fragment_auth_type.*
import toothpick.Scope
import javax.inject.Inject

class AuthTypeFragment : BaseFragment(), Presentable<AuthTypeScene.View, AuthTypeScene.Presenter>,
        ModulesInstallable, AuthTypeScene.View, View.OnClickListener {

    @Inject
    override lateinit var presenter: AuthTypeScene.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_auth_type, container, false);

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newUserBtn.setOnClickListener(this)
        signInBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) =
            when (v) {
                newUserBtn -> replaceFragment(requireActivity().authFrame.id, SignUpFragment(), true)
                signInBtn -> replaceFragment(requireActivity().authFrame.id, SignInFragment(), true)
                else -> Unit
            }

    override fun installModules(scope: Scope) {
        scope.installModules(ApiModule(), AuthTypeModule(this))
    }
}
