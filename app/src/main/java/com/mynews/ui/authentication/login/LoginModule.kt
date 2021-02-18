package com.mynews.ui.authentication.login

import androidx.lifecycle.ViewModel
import com.mynews.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    @Binds
    abstract fun bindLoginRepository(loginRepository: LoginRepository): LoginContract.Repository

    @Binds
    abstract fun bindLoginRouter(loginRouter: LoginRouter): LoginContract.Router
}