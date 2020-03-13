package net.simplifiedcoding.mvvmsampleapp.data.db

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration


class AppDatabase(context: Context) {

    init {
        buildDatabase()
    }

    private fun buildDatabase() =
        RealmConfiguration.Builder()
            .name("Tisha.realm")
            .schemaVersion(1)
            .build()

    companion object {
        fun getRealmInstance(): Realm = Realm.getDefaultInstance()

        fun closeRealmInstance(realm: Realm) = realm.close()
    }
}