package com.mynews.ui.savedarticles

import androidx.lifecycle.ViewModel
import com.mynews.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SavedArticlesModule {

    @Binds
    abstract fun bindRepository(savedArticlesRepository: SavedArticlesRepository): SavedArticlesContract.Repository

    @Binds
    abstract fun bindRouter(savedArticlesRouter: SavedArticlesRouter): SavedArticlesContract.Router

    @Binds
    @IntoMap
    @ViewModelKey(SavedArticlesViewModel::class)
    internal abstract fun bindViewModel(savedArticlesViewModel: SavedArticlesViewModel): ViewModel
}