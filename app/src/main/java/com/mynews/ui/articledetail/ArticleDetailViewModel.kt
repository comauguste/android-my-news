package com.mynews.ui.articledetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mynews.data.remote.NewsArticle
import com.mynews.util.cancelIfActive
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticleDetailViewModel @Inject constructor(
    private val detailRepository: ArticleDetailRepository
) : ViewModel() {
    private val mutableArticleDetailLiveData = MutableLiveData<NewsArticle>()
    val articleDetailLiveData = mutableArticleDetailLiveData
    private var getArticleJob: Job? = null

    fun getArticle(articleId: String) {
        getArticleJob.cancelIfActive()

        getArticleJob = viewModelScope.launch {
            detailRepository.getArticleDetail(articleId).collect {
                mutableArticleDetailLiveData.value = it
            }
        }
    }
}