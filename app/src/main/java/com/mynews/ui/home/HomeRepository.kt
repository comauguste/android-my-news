package com.mynews.ui.home

import com.mynews.base.BaseRepository
import com.mynews.data.remote.NewsArticle
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor() : BaseRepository() {
    fun getArticles() = flow {
        val articles = (myNewsApi.getArticles().body()?.articles ?: emptyList()).map {
            NewsArticle(
                id = it.id ?: "",
                title = it.title ?: "",
                description = it.description ?: "",
                sourcename = it.sourcename ?: "",
                url = it.url ?: "",
                urlToImage = it.urlToImage ?: "",
                content = it.content ?: "",
                author = it.author ?: "",
                publishedAt = it.publishedAt ?: ""
            )
        }.toList()

        emit(articles)
    }
}