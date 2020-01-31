package com.tushar.dagger22example.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tushar.dagger22example.R
import com.tushar.dagger22example.models.User
import com.tushar.dagger22example.ui.auth.AuthResource
import com.tushar.dagger22example.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {

    lateinit var viewModel: ProfileViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,providerFactory).get(ProfileViewModel::class.java)

        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.getAuthUser().removeObservers(viewLifecycleOwner)
        viewModel.getAuthUser().observe(viewLifecycleOwner, Observer {
            when(it.status){
                AuthResource.AuthStatus.AUTHENTICATED -> setUser(it.data)
                AuthResource.AuthStatus.ERROR -> setError(it.message)
            }
        })
    }

    private fun setError(message: String?) {
        email.text = "Error"
        message?.let{
            email.text = it
        }
        username.text = "Error"
        website.text = "Error"
    }

    private fun setUser(data: User?) {
        data?.let {
            email.text = it.email
            username.text = it.username
            website.text = it.website
        }
    }

}
