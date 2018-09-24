package com.ibrahimcherri.restaurants.presentation.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ibrahimcherri.restaurants.R
import com.ibrahimcherri.restaurants.domain.model.Restaurant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantsAdapter(private val restaurants: List<Restaurant>) :
        RecyclerView.Adapter<RestaurantsAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RestaurantsAdapter.RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        with(restaurants[position]) {
            holder.view.restaurantNameText.text = name
            holder.view.restaurantAddressText.text = address

            Picasso.with(holder.view.context)
                    .load(image)
                    .fit()
                    .into(holder.view.restaurantImage)
        }
    }

    override fun getItemCount() = restaurants.size
}