package com.ibrahimcherri.restaurants.domain

import com.ibrahimcherri.restaurants.domain.model.Restaurant
import javax.inject.Inject

open class UpdateRestaurantsInDatabaseUseCase @Inject constructor(private val restaurantRepository: RestaurantRepository) {

    open fun updateRestaurantsInDatabase(restaurant: List<Restaurant>) =
            restaurantRepository.updateRestaurants(restaurant)
}