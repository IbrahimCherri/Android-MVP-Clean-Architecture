package com.ibrahimcherri.restaurants.domain

import com.ibrahimcherri.restaurants.domain.model.Restaurant
import io.reactivex.Single

interface RestaurantRepository {

    fun updateRestaurants(restaurants: List<Restaurant>)
    fun getRestaurants(): Single<List<Restaurant>>
}