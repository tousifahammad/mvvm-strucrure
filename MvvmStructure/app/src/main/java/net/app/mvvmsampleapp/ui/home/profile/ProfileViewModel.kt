package net.app.mvvmsampleapp.ui.home.profile

import androidx.lifecycle.ViewModel;
import net.app.mvvmsampleapp.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
