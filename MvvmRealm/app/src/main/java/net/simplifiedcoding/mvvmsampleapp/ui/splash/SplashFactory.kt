package net.simplifiedcoding.mvvmsampleapp.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.simplifiedcoding.mvvmsampleapp.data.repositories.RestaurantRepository

@Suppress("UNCHECKED_CAST")
class SplashFactory(private val repository: RestaurantRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(repository) as T
    }
}