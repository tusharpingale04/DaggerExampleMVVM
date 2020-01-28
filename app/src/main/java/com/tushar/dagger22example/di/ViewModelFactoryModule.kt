package com.tushar.dagger22example.di

import androidx.lifecycle.ViewModelProvider
import com.tushar.dagger22example.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

}