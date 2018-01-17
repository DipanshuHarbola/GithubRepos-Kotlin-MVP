package com.deepanshu.githubrepos.services.repodata

import com.deepanshu.githubrepos.model.GithubRepo
import io.reactivex.Observable

interface GithubDataSource {
    fun getRepos(userName: String): Observable<List<GithubRepo>>
}