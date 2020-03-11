package net.app.mvvmsampleapp.ui.home.quotes

import androidx.lifecycle.ViewModel;
import net.app.mvvmsampleapp.data.repositories.QuotesRepository
import net.app.mvvmsampleapp.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
