package com.ibrahimcherri.restaurants.domain.model

import java.net.URI

data class Restaurant(val name: String,
                      val address: String,
                      val image: URI)