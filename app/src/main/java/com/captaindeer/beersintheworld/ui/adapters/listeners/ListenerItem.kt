package com.captaindeer.beersintheworld.ui.adapters.listeners

import com.captaindeer.beersintheworld.data.local.entities.BeerEntity

interface ListenerItem {

    fun beerDetailDialog(beerEntity: BeerEntity)

}