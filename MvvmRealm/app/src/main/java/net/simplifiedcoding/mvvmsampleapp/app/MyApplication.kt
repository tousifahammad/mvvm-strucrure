package net.simplifiedcoding.mvvmsampleapp.app

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import net.simplifiedcoding.mvvmsampleapp.data.db.AppDatabase
import net.simplifiedcoding.mvvmsampleapp.data.preferences.PreferenceProvider
import net.simplifiedcoding.mvvmsampleapp.data.repositories.RestaurantRepository
import net.simplifiedcoding.mvvmsampleapp.ui.auth.AuthFactory
import net.simplifiedcoding.mvvmsampleapp.ui.splash.SplashFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication : Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApplication))

        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { RestaurantRepository() }
        bind() from provider { AuthFactory(instance()) }
        bind() from provider { SplashFactory(instance()) }

    }

}