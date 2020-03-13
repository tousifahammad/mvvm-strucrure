package net.simplifiedcoding.mvvmsampleapp.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import net.simplifiedcoding.mvvmsampleapp.data.repositories.RestaurantRepository
import net.simplifiedcoding.mvvmsampleapp.ui.home.HomeActivity


class AuthViewModel(private val repository: RestaurantRepository) : ViewModel() {

    var pin: String? = null


    fun getLoggedInUser(id: String) = repository.getRestaurant(id)


    fun onOkclick(view: View) {
        Intent(view.context, HomeActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

}