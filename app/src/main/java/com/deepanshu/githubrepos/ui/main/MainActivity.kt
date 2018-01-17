package com.deepanshu.githubrepos.ui.main

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.util.Log
import android.view.inputmethod.InputMethodManager
import com.deepanshu.githubrepos.R
import com.deepanshu.githubrepos.model.GithubRepo
import com.deepanshu.githubrepos.ui.adapter.GithubRecyclerAdapter
import com.deepanshu.githubrepos.ui.base.BaseActivity
import com.deepanshu.githubrepos.utils.NetworkUtil
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainActivityContract.View {

    private val TAG: String = "MainActivity"
    private lateinit var recyclerAdapter: GithubRecyclerAdapter

    @Inject
    lateinit var network: NetworkUtil

    @Inject
    lateinit var mPresenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter.subscribe()

        recyclerAdapter = GithubRecyclerAdapter(this)
        list_view_repos.layoutManager = LinearLayoutManager(this)
        list_view_repos.adapter = recyclerAdapter

        button_search.setOnClickListener {
            val username = edit_text_username.text.toString()
            if (!TextUtils.isEmpty(username)) {
                if (!network.isConnected()){
                    hideKeyboard()
                    Snackbar.make(parent_layout, getString(R.string.no_internet), Snackbar.LENGTH_SHORT).show()
                }
                else {
                    mPresenter.gitHubUser(username)
                    mPresenter.loadData()
                    hideKeyboard()
                }
            }
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }

    override fun updateData(repo: List<GithubRepo>) {
        recyclerAdapter.setGitHubRepos(repo)
        Log.i(TAG, repo.toString())
    }

    override fun showMessage(msg: String) {
        Snackbar.make(parent_layout, msg, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unSubscribe()
    }

}
