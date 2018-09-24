package com.ibrahimcherri.restaurants.room

import com.ibrahimcherri.restaurants.domain.model.Restaurant
import com.ibrahimcherri.restaurants.room.model.RestaurantEntity
import org.junit.Test
import kotlin.test.assertEquals

class RestaurantEntityMapperTest {

    private val mockRestaurantEntity = RestaurantEntity(1, "name1", "address1", "image1")

    private val mockRestaurant = Restaurant("name1", "address1", "image1")

    @Test
    fun mapRestaurantsToDomain() {
        val restaurant = mapRestaurantEntityToDomain(mockRestaurantEntity)

        assertEquals(restaurant.name, mockRestaurant.name)
        assertEquals(restaurant.image, mockRestaurant.image)
        assertEquals(restaurant.address, mockRestaurant.address)
    }
}