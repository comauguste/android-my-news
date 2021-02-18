package com.mynews.ui.home

import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {

    @Binds
    abstract fun bindHomeRepository(homeRepository: HomeRepository): HomeRepository

    @Binds
    abstract fun bindHomeRouter(homeRouter: HomeRouter): HomeContract.Router
}