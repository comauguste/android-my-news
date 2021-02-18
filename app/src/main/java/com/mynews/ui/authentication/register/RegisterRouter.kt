package com.mynews.ui.authentication.register

import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class RegisterRouter @Inject constructor(
    private val registerFragment: RegisterFragment
) : RegisterContract.Router {

    override fun goToLoginPage() {
        val action = RegisterFragmentDirections.actionRegisterToLogin()
        registerFragment.findNavController().navigate(action)
    }

    override fun goToHomepage() {
        val action = RegisterFragmentDirections.actionRegisterToHome()
        registerFragment.findNavController().navigate(action)
    }
}