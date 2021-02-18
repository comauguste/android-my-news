package com.mynews.ui.authentication.register

import com.mynews.data.remote.request.LoginRequest
import com.mynews.data.remote.response.LoginResponse
import com.mynews.data.remote.response.User
import kotlinx.coroutines.flow.Flow

interface RegisterContract {
    interface Router {
        fun goToLoginPage()
        fun goToHomepage()
    }

    interface Repository {
        fun register(
            inputName: String,
            inputEmail: String,
            inputPassword: String,
            inputConfirmPassword: String
        ): Flow<User?>

        fun login(loginRequest: LoginRequest): Flow<LoginResponse?>
    }
}