package com.deepanshu.githubrepos.ui.main

import com.deepanshu.githubrepos.model.GithubRepo
import com.deepanshu.githubrepos.ui.base.BasePresenter
import com.deepanshu.githubrepos.ui.base.BaseView


interface MainActivityContract {

    interface View : BaseView {

        fun updateData(repo: List<GithubRepo>)

        fun showMessage(msg: String)
    }

    interface Presenter : BasePresenter {

        fun gitHubUser(userName: String)

        fun loadData()
    }
}