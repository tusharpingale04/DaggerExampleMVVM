package com.tushar.dagger22example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.tushar.dagger22example.models.User
import com.tushar.dagger22example.ui.auth.AuthResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val _cachedUser: MediatorLiveData<AuthResource<User>> = MediatorLiveData()

    val cachedUser: LiveData<AuthResource<User>>
        get() = _cachedUser


    fun authenticateWithId(source: LiveData<AuthResource<User>>){
        _cachedUser.value = AuthResource.loading(null)
        _cachedUser.addSource(source) {
            _cachedUser.value = it
            _cachedUser.removeSource(source)
        }

    }

    fun logOut(){
        _cachedUser.value = AuthResource.logout()

    }
}