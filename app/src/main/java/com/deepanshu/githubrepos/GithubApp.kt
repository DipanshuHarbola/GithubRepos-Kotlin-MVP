package com.deepanshu.githubrepos

import android.app.Activity
import android.app.Application
import com.deepanshu.githubrepos.di.DaggerAppComponent

import javax.inject.Inject

import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

class GithubApp : Application(), HasActivityInjector {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityInjector

}
