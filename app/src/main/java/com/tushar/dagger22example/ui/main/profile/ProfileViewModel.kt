package com.tushar.dagger22example.ui.main.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tushar.dagger22example.SessionManager
import com.tushar.dagger22example.models.User
import com.tushar.dagger22example.ui.auth.AuthResource
import javax.inject.Inject

class ProfileViewModel @Inject constructor(sessionManager: SessionManager) : ViewModel(){

    private val mSessionManager = sessionManager

    fun getAuthUser() : LiveData<AuthResource<User>> {
        return mSessionManager.cachedUser
    }
}