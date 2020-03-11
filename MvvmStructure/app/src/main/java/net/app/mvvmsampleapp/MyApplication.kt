package net.app.mvvmsampleapp

import android.app.Application
import net.app.mvvmsampleapp.data.db.AppDatabase
import net.app.mvvmsampleapp.data.network.MyApi
import net.app.mvvmsampleapp.data.network.NetworkConnectionInterceptor
import net.app.mvvmsampleapp.data.preferences.PreferenceProvider
import net.app.mvvmsampleapp.data.repositories.QuotesRepository
import net.app.mvvmsampleapp.data.repositories.UserRepository
import net.app.mvvmsampleapp.ui.auth.AuthViewModelFactory
import net.app.mvvmsampleapp.ui.home.profile.ProfileViewModelFactory
import net.app.mvvmsampleapp.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { QuotesRepository(instance(), instance(), instance()) }

        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }


    }

}