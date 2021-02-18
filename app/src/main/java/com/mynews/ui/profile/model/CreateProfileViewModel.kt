package com.mynews.ui.profile.model

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.button.MaterialButton
import com.mynews.R
import com.mynews.ui.profile.ProfileController

@EpoxyModelClass(layout = R.layout.epoxy_create_your_profile)
abstract class CreateProfileViewModel : EpoxyModelWithHolder<CreateProfileViewModel.Holder>() {

    @EpoxyAttribute
    lateinit var callback: ProfileController.ProfileCallBacks

    override fun bind(holder: Holder) {
        holder.createAccountButton.setOnClickListener { callback.onCreateAccountClicked() }
    }

    inner class Holder : EpoxyHolder() {
        lateinit var createAccountButton: MaterialButton
        override fun bindView(itemView: View) {
            createAccountButton = itemView.findViewById(R.id.button)
        }
    }
}