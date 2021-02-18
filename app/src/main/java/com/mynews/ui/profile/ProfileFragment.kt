package com.mynews.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mynews.R
import com.mynews.databinding.FragmentProfileBinding
import com.mynews.di.compose.ViewModelFragment
import com.mynews.util.UserHelper
import javax.inject.Inject

class ProfileFragment : ViewModelFragment(), ProfileController.ProfileCallBacks {

    @Inject
    lateinit var router: ProfileContract.Router

    @Inject
    lateinit var userHelper: UserHelper

    private val profileViewModel: ProfileViewModel by injectActivityVIewModels()
    private lateinit var binding: FragmentProfileBinding
    private val controller: ProfileController = ProfileController()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.setController(controller)
    }

    override fun onStart() {
        super.onStart()
        profileViewModel.fetchViewState()
        profileViewModel.loginStatusListenerLiveData.observe(viewLifecycleOwner, { isLoggedIn ->
            binding.loginTv.run {
                if (isLoggedIn) {
                    text = context.getString(R.string.log_out)
                    setOnClickListener { profileViewModel.logout() }

                } else {
                    text = context.getString(R.string.log_in)
                    setOnClickListener { router.goToLogin() }
                }
                controller.setData(userHelper, this@ProfileFragment)
            }
        })
    }

    override fun onCreateAccountClicked() {
        router.goToRegister()
    }

}