package com.tushar.dagger22example.di.auth

import com.tushar.dagger22example.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AuthModule {

    @JvmStatic
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}