package com.mynews.ui.home

import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class HomeRouter @Inject constructor(
    private val homeFragment: HomeFragment
) : HomeContract.Router {

    override fun goToLoginPage() {
        val action = HomeFragmentDirections.actionHomeToLogin()
        homeFragment.findNavController().navigate(action)
    }

    override fun goToArticleDetail(articleId: String) {
        val action = HomeFragmentDirections.actionHomeToArticleDetail(articleId)
        homeFragment.findNavController().navigate(action)
    }
}