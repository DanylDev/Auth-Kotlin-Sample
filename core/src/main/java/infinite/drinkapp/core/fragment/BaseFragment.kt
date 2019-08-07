package infinite.drinkapp.core.fragment

import android.app.ProgressDialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import infinite.drinkapp.core.R
import infinite.drinkapp.core.extension.hideKeyboard
import infinite.drinkapp.core.presentation.Action
import infinite.drinkapp.core.presentation.AlertPresentable
import infinite.drinkapp.core.presentation.KeyboardPresentable
import infinite.drinkapp.core.presentation.ProgressPresentable

abstract class BaseFragment : Fragment(), ProgressPresentable, AlertPresentable,
        KeyboardPresentable {
    private var alert: AlertDialog? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun showProgress() {
        if (progressDialog != null) return

        progressDialog = ProgressDialog(context)
        progressDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog?.isIndeterminate = true
        progressDialog?.setCancelable(false)
        progressDialog?.show()
        progressDialog?.setContentView(R.layout.progress)
    }

    override fun hideProgress() {
        progressDialog?.dismiss()
        progressDialog = null
    }

    override fun replaceFragment(containerViewId: Int, fragment: Fragment, addToBackStack: Boolean) {
        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()

        if (addToBackStack)
            fragmentTransaction?.addToBackStack(fragment::class.java.name)
        fragmentTransaction?.setCustomAnimations(R.anim.enter_animation, R.anim.stay, R.anim.stay, R.anim.exit_animation)
        fragmentTransaction?.replace(containerViewId, fragment)
        fragmentTransaction?.commitAllowingStateLoss()
    }

    override fun cleaBackStack(){
        activity?.supportFragmentManager?.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun openFragment(container: Int, fragment: Fragment, backStack: String) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(container, fragment)
        transaction.addToBackStack(backStack)
        transaction.commit()
    }

    override fun showAlert(
            title: String?,
            message: String?,
            positive: Action?,
            negative: Action?,
            neutral: Action?
    ) {
        alert?.dismiss()

        val alertBuilder = AlertDialog.Builder(requireContext())
        if (title != null && title.isNotBlank()) {
            alertBuilder.setTitle(title)
        }
        if (message != null && message.isNotBlank()) {
            alertBuilder.setMessage(message)
        }

        if (positive != null) {
            alertBuilder.setPositiveButton(positive.title, positive.listener)
        }
        if (negative != null) {
            alertBuilder.setNegativeButton(negative.title, negative.listener)
        }
        if (neutral != null) {
            alertBuilder.setNeutralButton(neutral.title, neutral.listener)
        }

        alert = alertBuilder.show()
    }

    override fun hideKeyboard() = activity?.hideKeyboard() ?: Unit


}

private val Action.listener: DialogInterface.OnClickListener?
    get() = action?.let {
        android.content.DialogInterface.OnClickListener { _, _ -> it() }
    }