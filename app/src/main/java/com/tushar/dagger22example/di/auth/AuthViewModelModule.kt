package com.tushar.dagger22example.di.auth

import androidx.lifecycle.ViewModel
import com.tushar.dagger22example.di.ViewModelKey
import com.tushar.dagger22example.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel) : ViewModel
}