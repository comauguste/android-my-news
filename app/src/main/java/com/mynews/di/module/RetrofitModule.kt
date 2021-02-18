package com.mynews.di.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun providesRetrofit(
        client: OkHttpClient,
        gson: Gson,
    ): Retrofit = builder(gson)
        .baseUrl("http://druideduweb.com/")
        .client(client)
        .build()


    private fun builder(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }
}