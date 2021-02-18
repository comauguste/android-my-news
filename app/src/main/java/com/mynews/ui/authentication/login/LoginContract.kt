package com.mynews.ui.authentication.login

import com.mynews.data.remote.response.CreatedUserResponse
import com.mynews.data.remote.response.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginContract {

    interface Router {
        fun goToHomePage()
        fun goToRegisterPage()
    }

    interface Repository {
        fun loginUser(email: String, password: String): Flow<LoginResponse?>
        fun getProfile(bearerToken: String): Flow<CreatedUserResponse?>
    }

}