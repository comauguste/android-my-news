package com.mynews.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mynews.util.UserHelper
import com.mynews.util.cancelIfActive
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val userHelper: UserHelper,
    private val repository: ProfileRepository
) : ViewModel() {

    val loginStatusListenerLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private var logUserOutJob: Job? = null

    fun fetchViewState() {
        loginStatusListenerLiveData.value = userHelper.isLoggedIn
    }

    fun logout() {
        logUserOutJob.cancelIfActive()
        logUserOutJob = viewModelScope.launch {
            repository.logout(userHelper.bearerToken).collect {
                userHelper.isLoggedIn = false
                userHelper.user = null
                loginStatusListenerLiveData.value = userHelper.isLoggedIn
            }
        }
    }
}