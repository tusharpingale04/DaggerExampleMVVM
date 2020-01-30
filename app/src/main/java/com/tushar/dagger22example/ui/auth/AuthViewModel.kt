package com.tushar.dagger22example.ui.auth

import androidx.lifecycle.*
import com.tushar.dagger22example.SessionManager
import javax.inject.Inject
import com.tushar.dagger22example.models.User
import com.tushar.dagger22example.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers

class AuthViewModel @Inject constructor(authApi: AuthApi, sessionManager: SessionManager) : ViewModel() {

    private val mAuthApi = authApi
    private val mSessionManager = sessionManager

    fun authenticateWithUser(id: String) {
        mSessionManager.authenticateWithId(queryById(id))
    }

    private fun queryById(id: String): LiveData<AuthResource<User>> {
        return LiveDataReactiveStreams.fromPublisher(
                mAuthApi
                .getUser(id)
                .onErrorReturn {
                    return@onErrorReturn User(id = -1)
                }
                .map {
                    if(it.id != -1){
                        AuthResource.authenticated(it)
                    }else{
                        AuthResource.error("Could not Authenticate",null)
                    }
                }
                .subscribeOn(Schedulers.io())) as LiveData<AuthResource<User>>
    }

    fun getAuthState() : LiveData<AuthResource<User>>{
        return mSessionManager.cachedUser
    }
}