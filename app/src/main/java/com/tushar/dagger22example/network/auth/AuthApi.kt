package com.tushar.dagger22example.network.auth

import com.tushar.dagger22example.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Flowable<User>
}