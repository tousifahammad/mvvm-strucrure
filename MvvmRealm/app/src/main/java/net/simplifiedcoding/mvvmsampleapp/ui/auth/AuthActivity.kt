package net.simplifiedcoding.mvvmsampleapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import net.simplifiedcoding.mvvmsampleapp.R
import net.simplifiedcoding.mvvmsampleapp.databinding.ActivityAuthBinding
import net.simplifiedcoding.mvvmsampleapp.ui.home.HomeActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class AuthActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: AuthFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityAuthBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_auth)
        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        val user =  viewModel.getLoggedInUser("1")
        if(user != null){
            Intent(this, HomeActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

    }

}
