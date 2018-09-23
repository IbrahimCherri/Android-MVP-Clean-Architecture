package com.ibrahimcherri.restaurants.data.model

import com.google.gson.annotations.SerializedName

data class LocationDetailsResponse(@SerializedName("best_rated_restaurant")
                                   val bestRestaurants: List<BestRestaurants>) {

    data class BestRestaurants(val restaurant: Restaurant) {

        data class Restaurant(val name: String,
                              @SerializedName("featured_image")
                              val imageUrl: String,
                              val location: Location) {

            data class Location(val address: String)
        }
    }
}