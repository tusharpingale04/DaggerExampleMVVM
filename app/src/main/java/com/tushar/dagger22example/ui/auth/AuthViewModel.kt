package com.tushar.dagger22example.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import com.tushar.dagger22example.models.User
import com.tushar.dagger22example.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers

class AuthViewModel @Inject constructor(authApi: AuthApi) : ViewModel() {

    private val mAuthApi = authApi

    private val _authUser: MediatorLiveData<User> = MediatorLiveData()

    val authUser: LiveData<User>
        get() = _authUser

    init {
        Log.d(TAG, "AuthViewModel: viewmodel is working...")
    }

    fun authenticateWithUser(id: String) {
        val source = LiveDataReactiveStreams.fromPublisher(
            mAuthApi
                .getUser(id)
                .subscribeOn(Schedulers.io())
        )

        _authUser.addSource(source) {
            _authUser.value = it
            _authUser.removeSource(source)
        }
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}