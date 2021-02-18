package com.mynews.ui.home

import com.airbnb.epoxy.Typed2EpoxyController
import com.mynews.data.remote.NewsArticle
import com.mynews.ui.home.model.newsArticleView
import com.mynews.util.safeLet

class HomeController :
    Typed2EpoxyController<List<NewsArticle>, HomeController.HomepageCallBacks>() {
    override fun buildModels(
        articles: List<NewsArticle>?,
        callBack: HomepageCallBacks?
    ) {
        safeLet(articles, callBack) { articles, callBack ->
            articles.forEach { article ->
                newsArticleView {
                    id(article.id)
                    articleId(article.id)
                    title(article.title)
                    description(article.description)
                    image(article.urlToImage)
                    callback(callBack)
                }
            }
        }
    }

    interface HomepageCallBacks {
        fun onArticleClicked(articleId: String)
    }
}