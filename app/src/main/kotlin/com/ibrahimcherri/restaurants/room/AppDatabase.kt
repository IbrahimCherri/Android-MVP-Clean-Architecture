package com.ibrahimcherri.restaurants.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ibrahimcherri.restaurants.room.model.RestaurantEntity


@Database(entities = [RestaurantEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
}