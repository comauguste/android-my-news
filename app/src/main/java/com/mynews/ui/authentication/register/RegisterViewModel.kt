package com.mynews.ui.authentication.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mynews.data.remote.request.LoginRequest
import com.mynews.util.Functions
import com.mynews.util.UserHelper
import com.mynews.util.cancelIfActive
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val userHelper: UserHelper,
    private val repository: RegisterRepository
) : ViewModel() {
    val toastLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val createdUserStatusLiveData = MutableLiveData<CreateUserStatus>()

    private var registerUserJob: Job? = null

    fun register(
        inputName: String,
        inputEmail: String,
        inputPassword: String,
        inputConfirmPassword: String
    ) {
        val name: String = inputName.trim { it <= ' ' }
        val email: String = inputEmail.trim { it <= ' ' }
        val password: String = inputPassword.trim { it <= ' ' }
        val confirmPassword: String = inputConfirmPassword.trim { it <= ' ' }


        // Check for empty data in the form
        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if (password != confirmPassword) {
                toastLiveData.value = ERROR_MESSAGE_PASSWORD_DO_NOT_MATCH
                return
            }
            if (Functions.isValidEmailAddress(email)) {
                registerUserJob.cancelIfActive()
                registerUserJob = viewModelScope.launch {
                    repository.register(name, email, password, confirmPassword).collect { user ->
                        if (user != null) {
                            repository.login(LoginRequest(email, password)).collect {
                                userHelper.user = user
                                userHelper.isLoggedIn = true
                                userHelper.loginResponse = it
                                createdUserStatusLiveData.value = CreateUserStatus.SUCCESS
                            }
                        }

                    }
                }
            } else {
                toastLiveData.value = ERROR_MESSAGE_EMAIL_IS_NOT_VALID
            }
        } else {
            toastLiveData.value = ERROR_MESSAGE_PLEASE_ENTER_YOUR_DETAILS

        }
    }

    companion object {
        const val ERROR_MESSAGE_EMAIL_IS_NOT_VALID = "Email is not valid!"
        const val ERROR_MESSAGE_PLEASE_ENTER_YOUR_DETAILS = "Please enter your details!"
        const val ERROR_MESSAGE_PASSWORD_DO_NOT_MATCH =
            "Password and Confirm Password do not match!"
        const val USER_CREATED = "CREATED"
    }
}