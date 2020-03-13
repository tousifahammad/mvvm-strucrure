package net.simplifiedcoding.mvvmsampleapp.data.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*


@RealmClass
open class Restaurant() : RealmObject() {
    @PrimaryKey
    var id: String = ""
    var name: String = ""
    var createdAt: Date = Date()
}