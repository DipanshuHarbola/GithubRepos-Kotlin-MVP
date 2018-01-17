package com.deepanshu.githubrepos.ui.main

import android.util.Log
import com.deepanshu.githubrepos.services.repodata.GithubDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject


class MainPresenterImplement @Inject constructor(private val githubDataSource: GithubDataSource, val view: MainActivityContract.View) : MainActivityContract.Presenter {

    private val TAG: String = "PresenterImp"
    private val mCompositeDisposable: CompositeDisposable? = CompositeDisposable()

    private var userName: String? = null

    override fun subscribe() {

    }

    override fun gitHubUser(userName: String) {
        this.userName = userName
    }

    override fun loadData() {
        val disposable = githubDataSource.getRepos(this.userName!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { githubRepo ->
                            Log.i(TAG, "Server response - " + githubRepo)
                            view.updateData(githubRepo)
                        },
                        { t ->
                            Log.e(TAG, t.message)
                            try {
                                @Suppress("DEPRECATION")
                                val erroeJson = (t as retrofit2.adapter.rxjava2.HttpException).response().errorBody()!!.source().readUtf8()
                                val jsonObject = JSONObject(erroeJson)
                                val errorMessage = jsonObject.getString("message")
                                view.showMessage(errorMessage)
                            } catch (e: NullPointerException) {
                                e.printStackTrace()
                            } catch (e: IOException) {
                                e.printStackTrace()
                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }
                        })
        mCompositeDisposable?.add(disposable)
    }

    override fun unSubscribe() {
        mCompositeDisposable?.clear()
    }
}