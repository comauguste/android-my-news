package com.mynews.base

import com.mynews.data.remote.MyNewsApi
import javax.inject.Inject

open class BaseRepository {
    @Inject
    protected lateinit var myNewsApi: MyNewsApi
}