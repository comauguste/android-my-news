package com.mynews.ui.authentication.login

import com.mynews.base.BaseRepository
import com.mynews.data.remote.request.LoginRequest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepository @Inject constructor() : BaseRepository(), LoginContract.Repository {

    override fun loginUser(email: String, password: String) = flow {
        val loginResponse = myNewsApi.login(LoginRequest(email, password)).body()
        emit(loginResponse)
    }

    override fun getProfile(bearerToken: String) = flow {
        val profileResponse = myNewsApi.getProfile(bearerToken).body()
        emit(profileResponse)
    }
}