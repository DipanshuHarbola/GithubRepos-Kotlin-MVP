package com.deepanshu.githubrepos.utils

import android.content.Context
import javax.inject.Inject
import android.net.NetworkInfo
import android.net.ConnectivityManager



class NetworkUtil @Inject constructor(private val mContext: Context) {

    fun isConnected(): Boolean {
        val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo?
        networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }


}