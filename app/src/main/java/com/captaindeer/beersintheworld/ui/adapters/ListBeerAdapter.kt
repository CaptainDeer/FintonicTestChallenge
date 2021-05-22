package com.captaindeer.beersintheworld.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.beersintheworld.R
import com.captaindeer.beersintheworld.data.local.entities.BeerEntity
import com.captaindeer.beersintheworld.ui.adapters.listeners.ListenerItem
import com.captaindeer.beersintheworld.ui.adapters.viewHolders.ListBeerViewHolder
import com.squareup.picasso.Picasso

class ListBeerAdapter(private var beers: ArrayList<BeerEntity>, private val listener: ListenerItem) : RecyclerView.Adapter<ListBeerViewHolder>() {

    fun updateData(beers: ArrayList<BeerEntity>) {
        this.beers = beers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListBeerViewHolder {
        return ListBeerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_beer, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListBeerViewHolder, position: Int) {
        val beer = beers[position]

        holder.name.text = beer.name
        holder.description.text = beer.description

        Picasso.get().load(beer.image_url).placeholder(R.drawable.notfound).into(holder.image)

        holder.itemView.setOnClickListener {
            listener.beerDetailDialog(beer)
        }
    }

    override fun getItemCount(): Int = beers.size
}