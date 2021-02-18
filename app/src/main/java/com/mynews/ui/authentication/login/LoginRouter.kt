package com.mynews.ui.authentication.login

import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class LoginRouter @Inject constructor(
    private val loginFragment: LoginFragment
) : LoginContract.Router {

    override fun goToHomePage() {
        val action = LoginFragmentDirections.actionLoginToHome()
        loginFragment.findNavController().navigate(action)
    }

    override fun goToRegisterPage() {
        val action = LoginFragmentDirections.actionLoginToRegister()
        loginFragment.findNavController().navigate(action)
    }
}