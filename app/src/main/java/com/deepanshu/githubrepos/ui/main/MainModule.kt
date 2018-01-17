package com.deepanshu.githubrepos.ui.main

import dagger.Module
import dagger.Binds



@Module
abstract class MainModule {

    @Binds
    internal abstract fun mView(
            mainActivity: MainActivity): MainActivityContract.View

    @Binds
    internal abstract fun mPresenter(
            presenterImplement: MainPresenterImplement): MainActivityContract.Presenter

}