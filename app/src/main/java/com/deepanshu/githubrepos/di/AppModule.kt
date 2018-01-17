package com.deepanshu.githubrepos.di

import android.app.Application
import android.content.Context
import com.deepanshu.githubrepos.GithubApp
import com.deepanshu.githubrepos.utils.NetworkUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.deepanshu.githubrepos.services.api.ApiClient
import com.deepanshu.githubrepos.services.api.ApiServices
import com.deepanshu.githubrepos.services.repodata.GithubData
import com.deepanshu.githubrepos.services.repodata.GithubDataSource


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideNetworkUtil(context: Context) : NetworkUtil = NetworkUtil(context)

    @Singleton
    @Provides
    fun provideApiService(): ApiServices = ApiClient.getGitHubService()

    @Singleton
    @Provides
    fun provideGithubDataSourse(mService: ApiServices): GithubDataSource = GithubData(mService)

}