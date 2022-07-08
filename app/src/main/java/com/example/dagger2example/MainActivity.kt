package com.example.dagger2example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger2example.databinding.ActivityMainBinding
import com.example.dagger2example.di.ImageLoader
import com.example.dagger2example.model.Profile
import com.example.dagger2example.network.GithubApi
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var githubApi: GithubApi

    @Inject
    lateinit var imageLoader: ImageLoader

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        githubApi.listRepos()
//            .enqueue(object : Callback<Profile> {
//
//                override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
//                    binding.tvResponse.text = response.body()?.login
//                }
//
//                override fun onFailure(call: Call<Profile>, t: Throwable) {
//                    binding.tvResponse.text = t.message
//
//                }
//
//            })

        githubApi.listReposWithRx()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                {
                    binding.tvResponse.text = it.message
                },{
                    binding.tvResponse.text = it.login
                    imageLoader.load(it.avtURL,binding.imageView)
                }
            )

    }
}