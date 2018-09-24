package com.ibrahimcherri.restaurants.data

import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse
import com.ibrahimcherri.restaurants.domain.model.Restaurant

fun mapLocationDetailsToDomainRestaurants(locationDetailsResponse: LocationDetailsResponse) =
        locationDetailsResponse.bestRestaurants.map {
            Restaurant(it.restaurant.name, it.restaurant.location.address, it.restaurant.imageUrl)
        }