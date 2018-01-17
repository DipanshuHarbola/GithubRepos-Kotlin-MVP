package com.deepanshu.githubrepos.di

import android.app.Application
import com.deepanshu.githubrepos.GithubApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, BuildersModule::class))
interface AppComponent
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: GithubApp)
}