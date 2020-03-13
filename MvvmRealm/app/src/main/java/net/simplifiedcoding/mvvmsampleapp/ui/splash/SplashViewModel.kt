package net.simplifiedcoding.mvvmsampleapp.ui.splash

import android.view.View
import androidx.lifecycle.ViewModel
import net.simplifiedcoding.mvvmsampleapp.data.repositories.RestaurantRepository
import net.simplifiedcoding.mvvmsampleapp.dialogs.DialogNewRestaurant
import net.simplifiedcoding.mvvmsampleapp.interfaces.DialogNewRestaurantListener

class SplashViewModel(private val repository: RestaurantRepository) : ViewModel(){
    var clickListener: DialogNewRestaurantListener? = null

    fun onNewRestaurantClick(view: View) {
        DialogNewRestaurant(view.context, clickListener!!).show()
    }
}