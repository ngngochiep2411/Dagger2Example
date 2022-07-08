package com.example.dagger2example.network

import com.example.dagger2example.model.Profile
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {

    @GET("users/thanhniencung")
    fun listRepos(): Call<Profile>

    @GET("users/thanhniencung")
    fun listReposWithRx() : Single<Profile>
}