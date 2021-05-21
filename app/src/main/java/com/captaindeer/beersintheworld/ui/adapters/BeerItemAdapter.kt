package com.captaindeer.beersintheworld.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.beersintheworld.R
import com.captaindeer.beersintheworld.data.remote.responses.BeerResponse
import com.captaindeer.beersintheworld.ui.adapters.listeners.ListenerItem
import com.captaindeer.beersintheworld.ui.adapters.viewHolders.BeerItemViewHolder
import com.squareup.picasso.Picasso

class BeerItemAdapter(
    private var beers: ArrayList<BeerResponse>,
    private val listener: ListenerItem
) : RecyclerView.Adapter<BeerItemViewHolder>() {

    fun updateData(beers: ArrayList<BeerResponse>) {
        this.beers = beers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerItemViewHolder {
        return BeerItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_beer, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BeerItemViewHolder, position: Int) {
        val beer = beers[position]

        holder.name.text = beer.name.toString()
        Picasso.get().load(beer.image_url).into(holder.img)
        holder.itemView.setOnClickListener {
            //     id = listener.getBeerId()
        }
    }

    override fun getItemCount(): Int = beers.size

}