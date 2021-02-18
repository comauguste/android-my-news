package com.mynews.ui.profile

import dagger.Binds
import dagger.Module

@Module
abstract class ProfileModule {

    @Binds
    abstract fun bindRepository(profileRepository: ProfileRepository): ProfileContract.Repository

    @Binds
    abstract fun bindRouter(profileRouter: ProfileRouter): ProfileContract.Router
}