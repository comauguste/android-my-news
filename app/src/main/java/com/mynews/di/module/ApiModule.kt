package com.mynews.di.module

import com.mynews.data.remote.MyNewsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun providesBf1Api(retrofit: Retrofit): MyNewsApi = retrofit.create(MyNewsApi::class.java)
}