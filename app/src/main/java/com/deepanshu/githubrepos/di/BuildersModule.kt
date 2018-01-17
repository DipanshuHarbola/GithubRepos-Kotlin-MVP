package com.deepanshu.githubrepos.di

import dagger.Module
import com.deepanshu.githubrepos.ui.main.MainActivity
import com.deepanshu.githubrepos.ui.main.MainModule
import dagger.android.ContributesAndroidInjector



@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    internal abstract fun bindMainActivity(): MainActivity
}