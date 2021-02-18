package com.mynews.ui.profile.model

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.mynews.R

@EpoxyModelClass(layout = R.layout.epoxy_user_profile)
abstract class UserProfileViewModel : EpoxyModelWithHolder<UserProfileViewModel.Holder>() {
    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var email: String

    override fun bind(holder: Holder) {
        holder.name.text = name
        holder.email.text = email
    }

    inner class Holder : EpoxyHolder() {
        lateinit var name: TextView
        lateinit var email: TextView
        override fun bindView(itemView: View) {
            name = itemView.findViewById(R.id.name)
            email = itemView.findViewById(R.id.email)
        }
    }
}