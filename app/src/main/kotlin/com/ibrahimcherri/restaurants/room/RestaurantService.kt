package com.ibrahimcherri.restaurants.room

import com.ibrahimcherri.restaurants.domain.RestaurantRepository
import com.ibrahimcherri.restaurants.domain.model.Restaurant
import com.ibrahimcherri.restaurants.room.model.RestaurantEntity
import io.reactivex.Single
import javax.inject.Inject

class RestaurantService @Inject constructor(var appDatabase: AppDatabase) : RestaurantRepository {

    override fun getRestaurants(): Single<List<Restaurant>> {
        return appDatabase.restaurantDao().getAll().flatMap { restaurants ->
            Single.just(restaurants.map { Restaurant(it.name, it.address, it.image) })
        }
    }

    override fun updateRestaurants(restaurants: List<Restaurant>) {
        appDatabase.restaurantDao().deleteAll()
        appDatabase.restaurantDao().updateAll(restaurants.map {
            RestaurantEntity(name = it.name, address = it.address, image = it.image)
        })
    }
}
