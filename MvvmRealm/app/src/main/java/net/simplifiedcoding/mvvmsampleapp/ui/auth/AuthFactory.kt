package net.simplifiedcoding.mvvmsampleapp.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.simplifiedcoding.mvvmsampleapp.data.repositories.RestaurantRepository

@Suppress("UNCHECKED_CAST")
class AuthFactory(
    private val repository: RestaurantRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}