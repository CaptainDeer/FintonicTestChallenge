package com.captaindeer.beersintheworld.data.remote.services

import com.captaindeer.beersintheworld.data.remote.responses.BeerResponse
import retrofit2.Response
import retrofit2.http.GET

interface BeerServices {

    @GET(value = "beers?page=10")
    suspend fun getBeers(): Response<ArrayList<BeerResponse>>

}