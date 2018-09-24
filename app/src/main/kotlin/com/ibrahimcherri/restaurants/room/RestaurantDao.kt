package com.ibrahimcherri.restaurants.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.ibrahimcherri.restaurants.room.model.RestaurantEntity
import io.reactivex.Single


@Dao
interface RestaurantDao {
    @Query("SELECT * FROM restaurant")
    fun getAll(): Single<List<RestaurantEntity>>

    @Insert
    fun updateAll(restaurants: List<RestaurantEntity>)

    @Query("DELETE FROM restaurant")
    fun deleteAll()
}