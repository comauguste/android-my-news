package com.mynews.ui.articledetail

import dagger.Binds
import dagger.Module

@Module
abstract class ArticleDetailModule {

    @Binds
    abstract fun bindRepository(articleDetailRepository: ArticleDetailRepository): ArticleDetailRepository

    @Binds
    abstract fun bindRouter(articleDetailRouter: ArticleDetailRouter): ArticleDetailContract.Router
}