package com.tushar.dagger22example.di

import com.tushar.dagger22example.di.auth.AuthModule
import com.tushar.dagger22example.di.auth.AuthViewModelModule
import com.tushar.dagger22example.di.main.MainFragmentBuildersModule
import com.tushar.dagger22example.di.main.MainModule
import com.tushar.dagger22example.di.main.MainViewModelModule
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

    @ContributesAndroidInjector(
        modules = [
            MainFragmentBuildersModule::class,
            MainViewModelModule::class,
            MainModule::class

        ]
    )
    abstract fun contributeMainActivity(): MainActivity

}