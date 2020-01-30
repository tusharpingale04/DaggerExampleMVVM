package com.tushar.dagger22example.di

import com.tushar.dagger22example.di.auth.AuthModule
import com.tushar.dagger22example.di.auth.AuthViewModelModule
import com.tushar.dagger22example.ui.auth.AuthActivity
import com.tushar.dagger22example.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            AuthViewModelModule::class,
            AuthModule::class
        ]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}