package com.mynews.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mynews.data.remote.NewsArticle
import com.mynews.util.cancelIfActive
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {
    private val mutableArticlesLiveData = MutableLiveData<List<NewsArticle>>()
    val articlesLiveData = mutableArticlesLiveData
    private var getArticleJob: Job? = null

    fun getArticles() {
        getArticleJob.cancelIfActive()

        getArticleJob = viewModelScope.launch {
            repository.getArticles().collect {
                mutableArticlesLiveData.value = it
            }
        }
    }
}