package com.mynews.di.component

import android.app.Application
import com.mynews.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ComposeModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        AndroidModule::class,
        HelperModule::class,
        RetrofitModule::class,
        ApiModule::class,
        NetModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}