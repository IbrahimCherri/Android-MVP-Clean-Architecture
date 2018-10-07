package com.ibrahimcherri.restaurants.data

import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse
import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse.BestRestaurants
import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse.BestRestaurants.Restaurant
import com.ibrahimcherri.restaurants.data.model.LocationDetailsResponse.BestRestaurants.Restaurant.Location
import com.nhaarman.mockito_kotlin.given
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.Test
import kotlin.test.assertEquals
import com.ibrahimcherri.restaurants.domain.model.Restaurant as DomainRestaurant

class RestaurantsDataMapperTest : Spek( {

    val mockLocationDetailsResponse = LocationDetailsResponse(listOf(
            BestRestaurants(Restaurant("name1", "image1", Location("address1"))),
            BestRestaurants(Restaurant("name2", "image2", Location("address2"))),
            BestRestaurants(Restaurant("name3", "image3", Location("address3")))
    ))

    val mockRestaurants = listOf(DomainRestaurant("name1", "address1", "image1"),
            DomainRestaurant("name2", "address2", "image2"),
            DomainRestaurant("name3", "address3", "image3"))

    given("I received a list of restaurants data from the api") {
        it("maps the data list to a domain list") {
            val restaurants = mapLocationDetailsToDomainRestaurants(mockLocationDetailsResponse)

            restaurants.forEachIndexed { index, restaurant ->
                assertEquals(restaurant.name, mockRestaurants[index].name)
                assertEquals(restaurant.image, mockRestaurants[index].image)
                assertEquals(restaurant.address, mockRestaurants[index].address)
            }
        }
    }
})