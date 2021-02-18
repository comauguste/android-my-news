package com.mynews.ui.savedarticles

import com.mynews.ui.profile.ProfileContract
import javax.inject.Inject

class SavedArticlesRouter @Inject constructor(
    private val savedArticlesFragment: SavedArticlesFragment
) : SavedArticlesContract.Router {
}