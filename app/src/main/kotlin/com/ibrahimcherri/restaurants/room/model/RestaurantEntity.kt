package com.ibrahimcherri.restaurants.room.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "restaurant")
data class RestaurantEntity(@PrimaryKey(autoGenerate = true)
                            var id: Long? = null,

                            var name: String,

                            var address: String,

                            var image: String)