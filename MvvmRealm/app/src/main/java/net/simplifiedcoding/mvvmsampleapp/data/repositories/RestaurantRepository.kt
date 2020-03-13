package net.simplifiedcoding.mvvmsampleapp.data.repositories

import net.simplifiedcoding.mvvmsampleapp.data.dao.RestaurantDao

class RestaurantRepository() {

    fun addRestaurant(name: String) = RestaurantDao.addRestaurantToDB(name)

    fun getRestaurant(id: String) = RestaurantDao.getRestaurantById(id)

}