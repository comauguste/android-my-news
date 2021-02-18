package com.mynews

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun providesNavigator(activity: MainActivity): NavController {
        return (activity.supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            .navController
    }
}