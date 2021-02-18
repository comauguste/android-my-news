package com.mynews.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mancj.materialsearchbar.MaterialSearchBar
import com.mynews.databinding.FragmentHomeBinding
import com.mynews.di.compose.ViewModelFragment
import javax.inject.Inject

class HomeFragment : ViewModelFragment(), MaterialSearchBar.OnSearchActionListener,
    HomeController.HomepageCallBacks {

    @Inject
    lateinit var router: HomeContract.Router
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by injectActivityVIewModels()
    private val controller = HomeController()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.setController(controller)
        setupSearchBar()
        initData()
    }

    private fun initData() {
        homeViewModel.getArticles()
        homeViewModel.articlesLiveData.observe(viewLifecycleOwner, {
            controller.setData(it, this)
        })
    }

    private fun setupSearchBar() {
        binding.searchBarComponent.searchBar.setOnSearchActionListener(this)
        binding.searchBarComponent.searchBar.setPlaceHolder("Search latest news...")
        binding.searchBarComponent.searchBar.setCardViewElevation(10)
        binding.searchBarComponent.searchBar.addTextChangeListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {}
        })
    }

    override fun onSearchStateChanged(enabled: Boolean) {
    }

    override fun onSearchConfirmed(text: CharSequence?) {
    }

    override fun onButtonClicked(buttonCode: Int) {
    }

    override fun onArticleClicked(articleId: String) {
        router.goToArticleDetail(articleId)
    }
}