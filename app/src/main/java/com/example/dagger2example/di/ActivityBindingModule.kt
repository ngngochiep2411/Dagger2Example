package com.example.dagger2example.di

import com.example.dagger2example.MainActivity
import com.example.dagger2example.MainActivity2
import dagger.Module
import dagger.android.ContributesAndroidInjector
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
    abstract fun bindMainActivity2(): MainActivity2
}