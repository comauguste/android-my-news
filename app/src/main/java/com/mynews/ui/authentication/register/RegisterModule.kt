package com.mynews.ui.authentication.register

import dagger.Binds
import dagger.Module

@Module
abstract class RegisterModule {

    @Binds
    abstract fun bindRegisterRepository(loginRepository: RegisterRepository): RegisterContract.Repository

    @Binds
    abstract fun bindRegisterRouter(registerRouter: RegisterRouter): RegisterContract.Router

}