package com.tushar.dagger22example.di.main

import com.tushar.dagger22example.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun provideProfileFragment() : ProfileFragment
}