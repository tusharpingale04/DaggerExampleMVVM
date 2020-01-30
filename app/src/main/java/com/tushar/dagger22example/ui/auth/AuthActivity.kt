package com.tushar.dagger22example.ui.auth

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.tushar.dagger22example.BaseActivity
import com.tushar.dagger22example.R
import com.tushar.dagger22example.ui.main.MainActivity
import com.tushar.dagger22example.viewmodels.ViewModelProviderFactory
import javax.inject.Inject
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var drawable: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel::class.java)
        setLogo()

        login_button.setOnClickListener {
            attemptLogin()
        }

        viewModel.getAuthState().observe(this, Observer {
            it?.let {
                when (it.status) {
                    AuthResource.AuthStatus.LOADING -> {
                        showProgressBar(true)
                    }
                    AuthResource.AuthStatus.AUTHENTICATED -> {
                        showProgressBar(false)
                        Log.d(TAG, "User Authenticated: " + it.data?.email)
                        onLoginSuccess()
                    }
                    AuthResource.AuthStatus.ERROR -> {
                        showProgressBar(false)
                        Toast.makeText(
                            this,
                            "Enter No between 1 to 10 " + it.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    AuthResource.AuthStatus.NOT_AUTHENTICATED -> {
                        showProgressBar(false)
                    }
                }
            }
        })
    }

    private fun onLoginSuccess(){
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun showProgressBar(isVisible: Boolean) {
        if (isVisible) {
            progress_bar.visibility = View.VISIBLE
        } else {
            progress_bar.visibility = View.GONE
        }
    }

    private fun attemptLogin() {
        if (TextUtils.isEmpty(user_id_input.text)) {
            return
        }
        viewModel.authenticateWithUser(user_id_input.text.toString())
    }

    private fun setLogo() {
        requestManager.load(drawable).into(login_logo)
    }

    companion object {
        private const val TAG = "AuthActivity"
    }
}
