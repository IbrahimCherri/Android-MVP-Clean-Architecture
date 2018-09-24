package com.ibrahimcherri.restaurants.domain

import com.ibrahimcherri.restaurants.domain.model.Restaurant
import io.reactivex.Single
import javax.inject.Inject

open class GetRestaurantsFromDatabaseUseCase @Inject constructor(private val restaurantRepository: RestaurantRepository) {

    open fun geRestaurantsFromDatabase(): Single<List<Restaurant>> =
            restaurantRepository.getRestaurants()
}