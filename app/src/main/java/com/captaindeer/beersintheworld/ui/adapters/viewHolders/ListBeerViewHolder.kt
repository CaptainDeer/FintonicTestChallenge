package com.captaindeer.beersintheworld.ui.adapters.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.beersintheworld.R

class ListBeerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val image = view.findViewById(R.id.img_beer_list) as ImageView
    val name = view.findViewById(R.id.tv_beer_list) as TextView
    val description = view.findViewById(R.id.tv_description_list) as TextView

}