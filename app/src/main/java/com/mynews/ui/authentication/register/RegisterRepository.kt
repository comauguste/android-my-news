package com.mynews.ui.authentication.register

import com.mynews.base.BaseRepository
import com.mynews.data.remote.request.CreateUserRequest
import com.mynews.data.remote.request.LoginRequest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterRepository @Inject constructor() : BaseRepository(), RegisterContract.Repository {
    override fun register(
        inputName: String,
        inputEmail: String,
        inputPassword: String,
        inputConfirmPassword: String
    ) = flow {
        val createdUserResponse = myNewsApi.registerUser(
            CreateUserRequest(
                inputEmail, inputName,
                inputPassword, inputConfirmPassword
            )
        )

        emit(createdUserResponse.body()?.user)
    }

    override fun login(loginRequest: LoginRequest) = flow {
        val loginResponse = myNewsApi.login(loginRequest)
        emit(loginResponse.body())
    }

}