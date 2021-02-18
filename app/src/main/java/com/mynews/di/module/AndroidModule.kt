package com.mynews.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.annotation.NonNull
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule {

    @Provides
    @Singleton
    fun providesContext(@NonNull application: Application): Context = application

    @Provides
    @Singleton
    fun providesResources(@NonNull application: Application): Resources = application.resources

    @Provides
    @Singleton
    fun providesSharedPreferences(@NonNull application: Application): SharedPreferences {
        return application.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
    }

    companion object {
        const val SHARED_PREFERENCE_FILE_NAME = "default_preferences"
    }
}