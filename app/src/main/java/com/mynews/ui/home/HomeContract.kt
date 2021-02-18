package com.mynews.ui.home

import com.mynews.data.remote.NewsArticle

interface HomeContract {
    interface Router {
        fun goToLoginPage()
        fun goToArticleDetail(articleId: String)
    }

    interface Repository {
        fun getArticles(): List<NewsArticle>
    }
}