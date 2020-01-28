package com.tushar.dagger22example.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.tushar.dagger22example.R
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

        viewModel.authUser.observe(this, Observer {
            it?.let {
                Toast.makeText(this, it.name, Toast.LENGTH_LONG).show()
            }
        })
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
