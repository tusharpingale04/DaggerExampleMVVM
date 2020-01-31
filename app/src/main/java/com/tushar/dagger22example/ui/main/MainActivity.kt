package com.tushar.dagger22example.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import android.widget.Toast
import com.tushar.dagger22example.BaseActivity
import com.tushar.dagger22example.R
import com.tushar.dagger22example.ui.main.profile.ProfileFragment


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showProfile()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.action_logout -> {
                sessionManager.logOut()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showProfile(){
        supportFragmentManager.beginTransaction().replace(R.id.main_container,ProfileFragment()).commit()
    }
}
