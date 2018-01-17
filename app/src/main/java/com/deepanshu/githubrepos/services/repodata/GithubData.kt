package com.deepanshu.githubrepos.services.repodata

import com.deepanshu.githubrepos.model.GithubRepo
import com.deepanshu.githubrepos.services.api.ApiServices
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubData @Inject
constructor(private val mService: ApiServices) : GithubDataSource {

    override fun getRepos(userName: String): Observable<List<GithubRepo>> {
        return mService.getRepositories(userName)
    }
}