package com.mynews.ui.savedarticles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mynews.databinding.FragmentSavedArticlesBinding
import com.mynews.di.compose.ViewModelFragment
import com.mynews.ui.profile.ProfileViewModel

class SavedArticlesFragment : ViewModelFragment() {

    private val savedArticlesViewModel: ProfileViewModel by injectActivityVIewModels()
    lateinit var binding: FragmentSavedArticlesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }
}