package com.tushar.dagger22example

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.tushar.dagger22example.ui.auth.AuthActivity
import com.tushar.dagger22example.ui.auth.AuthResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        sessionManager.cachedUser.observe(this, Observer {
            it?.let {
                when (it.status) {
                    AuthResource.AuthStatus.LOADING -> {

                    }
                    AuthResource.AuthStatus.AUTHENTICATED -> {
                        Log.d(TAG, "User Authenticated: " + it.data?.email)
                    }
                    AuthResource.AuthStatus.ERROR -> {
                    }
                    AuthResource.AuthStatus.NOT_AUTHENTICATED -> {
                        logOut()
                    }
                }
            }
        })
    }

    private fun logOut() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    companion object {
        const val TAG = "BaseActivity"
    }
}