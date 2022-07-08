package com.example.dagger2example.di

import com.example.dagger2example.network.GithubApi
import com.example.dagger2example.network.GithubService
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesGithubAPi(): GithubApi = GithubService.create()

    @Provides
    fun loadImage() = ImageLoader()
}