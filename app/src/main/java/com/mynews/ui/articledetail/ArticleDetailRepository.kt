package com.mynews.ui.articledetail

import com.mynews.base.BaseRepository
import com.mynews.data.remote.NewsArticle
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArticleDetailRepository @Inject constructor() : BaseRepository() {
    fun getArticleDetail(id: String) = flow {
        val article = myNewsApi.getArticleDetail(id).body()?.article?.let {
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
        } ?: NewsArticle(id, "", "", "", "", "", "", "", "")

        emit(article)
    }
}