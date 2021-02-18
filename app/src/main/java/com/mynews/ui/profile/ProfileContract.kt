package com.mynews.ui.profile

import kotlinx.coroutines.flow.Flow

interface ProfileContract {
    interface Router {
        fun goToLogin()
        fun goToRegister()
    }

    interface Repository {
        fun logout(bearerToken: String): Flow<String>
    }
}