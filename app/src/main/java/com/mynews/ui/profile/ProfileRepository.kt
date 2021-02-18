package com.mynews.ui.profile

import com.mynews.base.BaseRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileRepository @Inject constructor() : BaseRepository(), ProfileContract.Repository {
    override fun logout(bearerToken: String) = flow {
        val message = myNewsApi.logout(bearerToken).message()
        emit(message)
    }
}