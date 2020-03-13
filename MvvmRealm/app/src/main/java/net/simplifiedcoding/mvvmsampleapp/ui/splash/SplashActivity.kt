package net.simplifiedcoding.mvvmsampleapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import net.simplifiedcoding.mvvmsampleapp.R
import net.simplifiedcoding.mvvmsampleapp.databinding.ActivitySplashBinding
import net.simplifiedcoding.mvvmsampleapp.interfaces.DialogNewRestaurantListener
import net.simplifiedcoding.mvvmsampleapp.ui.auth.AuthActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SplashActivity : AppCompatActivity(), KodeinAware, DialogNewRestaurantListener {

    override val kodein by kodein()
    private val factory: SplashFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySplashBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)
        val viewModel = ViewModelProviders.of(this, factory).get(SplashViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.clickListener = this
    }


    override fun onStartClicked() {
        Intent(this, AuthActivity::class.java).also {
            startActivity(it)
        }
    }
}
