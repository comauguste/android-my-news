package com.mynews.ui.authentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mynews.ui.authentication.register.CreateUserStatus
import com.mynews.util.Functions
import com.mynews.util.UserHelper
import com.mynews.util.cancelIfActive
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userHelper: UserHelper,
    private val loginRepository: LoginRepository
) : ViewModel() {
    val toastLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val loginUserStatusLiveData = MutableLiveData<CreateUserStatus>()

    private var loginUserJob: Job? = null
    fun login(email: String, password: String) {
        // Check for empty data in the form
        if (email.isNotEmpty() && password.isNotEmpty()) {
            if (Functions.isValidEmailAddress(email)) {
                // login user
                loginUserJob.cancelIfActive()
                loginUserJob = viewModelScope.launch {
                    loginRepository.loginUser(email, password).collect { loginResponse ->
                        userHelper.loginResponse = loginResponse
                        loginRepository.getProfile(userHelper.bearerToken).collect {
                            userHelper.user = it?.user
                            userHelper.isLoggedIn = true
                            loginUserStatusLiveData.value = CreateUserStatus.SUCCESS
                        }
                    }
                }
            } else {
                toastLiveData.value = ERROR_MESSAGE_EMAIL_IS_NOT_VALID
            }
        } else {
            // Prompt user to enter credentials
            toastLiveData.value = ERROR_MESSAGE_PLEASE_ENTER_YOUR_DETAILS
        }
    }


    companion object {
        const val ERROR_MESSAGE_EMAIL_IS_NOT_VALID = "Email is not valid!"
        const val ERROR_MESSAGE_PLEASE_ENTER_YOUR_DETAILS = "Please enter your details!"
    }
}