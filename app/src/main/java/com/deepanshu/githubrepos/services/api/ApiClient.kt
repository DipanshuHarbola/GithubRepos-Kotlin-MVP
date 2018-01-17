package com.deepanshu.githubrepos.services.api

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient

class ApiClient {

    companion object {
        private val BASE_URL = "https://api.github.com/"
        fun getGitHubService(): ApiServices {
            val httpClient = OkHttpClient.Builder()
            val okHttpClient = httpClient.build()

            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create<ApiServices>(ApiServices::class.java)
        }
    }

}