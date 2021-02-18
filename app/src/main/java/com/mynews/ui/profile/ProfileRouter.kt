package com.mynews.ui.profile

import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class ProfileRouter @Inject constructor(
    private val profileFragment: ProfileFragment
) : ProfileContract.Router {
    override fun goToLogin() {
        val action = ProfileFragmentDirections.actionProfileToLogin()
        profileFragment.findNavController().navigate(action)
    }

    override fun goToRegister() {
        val action = ProfileFragmentDirections.actionProfileToRegister()
        profileFragment.findNavController().navigate(action)
    }
}