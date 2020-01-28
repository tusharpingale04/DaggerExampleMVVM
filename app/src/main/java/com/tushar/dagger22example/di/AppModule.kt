package com.tushar.dagger22example.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.tushar.dagger22example.BuildConfig
import com.tushar.dagger22example.R
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
object AppModule {

    @Singleton
    @JvmStatic
    @Provides
    fun provideRequestOption(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.white_background)
            .error(R.drawable.white_background)
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide
            .with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideAppDrawable(application: Application) : Drawable{
        return ContextCompat.getDrawable(application,R.drawable.logo)!!
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideRetrofitInstance() : Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


    }

}

