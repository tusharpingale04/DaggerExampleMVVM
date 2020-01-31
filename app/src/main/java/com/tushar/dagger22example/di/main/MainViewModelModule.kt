package com.tushar.dagger22example.di.main

import androidx.lifecycle.ViewModel
import com.tushar.dagger22example.di.ViewModelKey
import com.tushar.dagger22example.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel) : ViewModel


}