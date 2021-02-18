package com.mynews.ui.profile

import com.airbnb.epoxy.Typed2EpoxyController
import com.mynews.ui.profile.model.createProfileView
import com.mynews.ui.profile.model.userProfileView
import com.mynews.util.UserHelper

class ProfileController : Typed2EpoxyController<UserHelper, ProfileController.ProfileCallBacks>() {
    override fun buildModels(userHelper: UserHelper, callBacks: ProfileCallBacks?) {
        if (userHelper.isLoggedIn) {
            userHelper.user?.run {
                userProfileView {
                    id(hashCode())
                    name(name)
                    email(email)
                }
            }
        } else {
            createProfileView {
                id(hashCode())
                callback(callBacks)
            }
        }
    }

    interface ProfileCallBacks {
        fun onCreateAccountClicked()
    }
}