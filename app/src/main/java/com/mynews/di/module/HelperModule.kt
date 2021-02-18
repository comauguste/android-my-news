package com.mynews.di.module

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mynews.util.UserHelper
import com.mynews.util.rx.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HelperModule {

    @Provides
    @Singleton
    fun providesUserHelper(sharedPreferences: SharedPreferences, gson: Gson): UserHelper {
        return UserHelper(sharedPreferences, gson)
    }

    @Provides
    @Singleton
    fun providesScheduler(): SchedulerProvider {
        return SchedulerProvider()
    }
}