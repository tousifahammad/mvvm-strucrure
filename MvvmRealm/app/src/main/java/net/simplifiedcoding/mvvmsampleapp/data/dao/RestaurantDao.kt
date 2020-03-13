package net.simplifiedcoding.mvvmsampleapp.data.dao

import android.util.Log
import androidx.lifecycle.LiveData
import io.realm.kotlin.where
import net.simplifiedcoding.mvvmsampleapp.data.db.AppDatabase
import net.simplifiedcoding.mvvmsampleapp.data.entities.Restaurant
import java.util.*

class RestaurantDao {

    companion object {

        fun addRestaurantToDB(name: String) {
            val realm = AppDatabase.getRealmInstance()

            try {
                realm.beginTransaction()
                val restaurant: Restaurant =
                    realm.createObject(Restaurant::class.java, UUID.randomUUID().toString())
                restaurant.name = name

                realm.commitTransaction()
            } catch (error: Exception) {
                Log.d("1111", "Error : ${error.printStackTrace()}")
            } finally {
                realm.close()
            }

        }


        fun getRestaurantById(id: String): Restaurant? {
            val realm = AppDatabase.getRealmInstance()
            var restaurant: Restaurant? = null
            try {
                restaurant = realm.where<Restaurant>().equalTo("id", id)?.findFirst()!!
            } catch (error: Exception) {
                Log.d("1111", "Error : ${error.printStackTrace()}")
            } finally {

            }
            return restaurant
        }
    }

}