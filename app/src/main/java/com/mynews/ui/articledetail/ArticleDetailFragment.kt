package com.mynews.ui.articledetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mynews.R
import com.mynews.data.remote.NewsArticle
import com.mynews.databinding.FragmentArticleDetailBinding
import com.mynews.di.compose.ViewModelFragment
import javax.inject.Inject

class ArticleDetailFragment : ViewModelFragment() {
    @Inject
    lateinit var router: ArticleDetailContract.Router
    private val articleDetailViewModel: ArticleDetailViewModel by injectActivityVIewModels()
    private lateinit var binding: FragmentArticleDetailBinding
    val args: ArticleDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setupToolBar()
        fetchArticleDetail()
    }

    private fun fetchArticleDetail() {
        articleDetailViewModel.getArticle(args.articleId)
        articleDetailViewModel.articleDetailLiveData.observe(viewLifecycleOwner, { article ->
            article?.let {
                setupArticleDetail(it)
            }
        })
    }

    private fun setupArticleDetail(article: NewsArticle) {
        binding.run {
            image.setImageURI(article.urlToImage)
            title.text = article.title
            content.text = article.description
            author.text = article.author
            source.text = article.sourcename
            date.text = article.publishedAt
            shareButton.setOnClickListener { router.shareArticle(article.url) }
        }

    }

    private fun setupToolBar() {
        binding.toolbar.run {
            title = "Detail"
            setNavigationIcon(R.drawable.ic_back)
            setNavigationOnClickListener { findNavController().popBackStack() }
        }
    }
}