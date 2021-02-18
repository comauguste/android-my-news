package com.mynews

import com.facebook.drawee.backends.pipeline.Fresco
import com.mynews.di.component.DaggerAppComponent
import dagger.android.DaggerApplication

class MyNewsApplication : DaggerApplication() {

    private val appComponent = DaggerAppComponent.factory().create(this)

    override fun applicationInjector() = appComponent

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)
    }
}