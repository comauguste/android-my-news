package com.mynews.ui.savedarticles

import com.mynews.base.BaseRepository
import javax.inject.Inject

class SavedArticlesRepository @Inject constructor() : BaseRepository(),
    SavedArticlesContract.Repository {

}