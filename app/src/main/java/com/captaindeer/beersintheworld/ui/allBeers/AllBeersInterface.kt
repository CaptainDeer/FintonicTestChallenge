package com.captaindeer.beersintheworld.ui.allBeers

import com.captaindeer.beersintheworld.data.local.entities.BeerEntity
import com.captaindeer.beersintheworld.data.remote.responses.BeerResponse
import com.captaindeer.beersintheworld.ui.bases.BasePresenter
import com.captaindeer.beersintheworld.ui.bases.BaseView

interface AllBeersInterface {

    interface Presenter : BasePresenter {
        fun getBeers()
    }

    interface View : BaseView {
        fun setBeers(beers: ArrayList<BeerEntity>)
        fun setListBeers(beers: ArrayList<BeerEntity>)
    }

}