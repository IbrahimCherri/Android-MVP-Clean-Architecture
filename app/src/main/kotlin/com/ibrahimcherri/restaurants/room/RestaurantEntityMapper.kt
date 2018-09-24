package com.ibrahimcherri.restaurants.room

import com.ibrahimcherri.restaurants.domain.model.Restaurant
import com.ibrahimcherri.restaurants.room.model.RestaurantEntity

fun mapRestaurantEntityToDomain(restaurantEntity: RestaurantEntity) =
        Restaurant(restaurantEntity.name, restaurantEntity.address, restaurantEntity.image)