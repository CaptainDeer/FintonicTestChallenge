package com.captaindeer.beersintheworld.ui.adapters.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.beersintheworld.R
import kotlinx.android.synthetic.main.item_beer.view.*

class BeerItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val img = view.findViewById(R.id.item_img) as ImageView
    val name = view.findViewById(R.id.item_name) as TextView

}