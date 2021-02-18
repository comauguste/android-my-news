/*
 * The MIT License (MIT)
 *
 * Designed and developed by 2018 skydoves (Jaewoong Eum)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mynews.di.module

import com.mynews.di.annotations.FragmentScope
import com.mynews.ui.articledetail.ArticleDetailFragment
import com.mynews.ui.articledetail.ArticleDetailModule
import com.mynews.ui.authentication.login.LoginFragment
import com.mynews.ui.authentication.login.LoginModule
import com.mynews.ui.authentication.register.RegisterFragment
import com.mynews.ui.authentication.register.RegisterModule
import com.mynews.ui.home.HomeFragment
import com.mynews.ui.home.HomeModule
import com.mynews.ui.profile.ProfileFragment
import com.mynews.ui.profile.ProfileModule
import com.mynews.ui.savedarticles.SavedArticlesFragment
import com.mynews.ui.savedarticles.SavedArticlesModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ProfileModule::class])
    abstract fun contributeProfileFragment(): ProfileFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [SavedArticlesModule::class])
    abstract fun contributeSavedArticlesFragment(): SavedArticlesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ArticleDetailModule::class])
    abstract fun contributeArticleDetailFragment(): ArticleDetailFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun contributeLoginFragment(): LoginFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [RegisterModule::class])
    abstract fun contributeRegisterFragment(): RegisterFragment
}
