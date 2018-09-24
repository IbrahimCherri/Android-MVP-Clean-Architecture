package com.ibrahimcherri.restaurants.data

import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse
import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse.BestRestaurants
import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse.BestRestaurants.Restaurant
import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse.BestRestaurants.Restaurant.Location
import org.junit.Test
import kotlin.test.assertEquals
import com.ibrahimcherri.restaurants.domain.model.Restaurant as DomainRestaurant

class RestaurantsDataMapperTest {

    private val mockLocationDetailsResponse = LocationDetailsResponse(listOf(
            BestRestaurants(Restaurant("name1", "image1", Location("address1"))),
            BestRestaurants(Restaurant("name2", "image2", Location("address2"))),
            BestRestaurants(Restaurant("name3", "image3", Location("address3")))
    ))

    private val mockRestaurants = listOf(DomainRestaurant("name1", "address1", "image1"),
            DomainRestaurant("name2", "address2", "image2"),
            DomainRestaurant("name3", "address3", "image3"))

    @Test
    fun mapRestaurantsToDomain() {
        val restaurants = mapLocationDetailsToDomainRestaurants(mockLocationDetailsResponse)

        restaurants.forEachIndexed { index, restaurant ->
            assertEquals(restaurant.name, mockRestaurants[index].name)
            assertEquals(restaurant.image, mockRestaurants[index].image)
            assertEquals(restaurant.address, mockRestaurants[index].address)
        }
    }
}