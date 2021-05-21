package com.captaindeer.beersintheworld.data.remote

import com.captaindeer.beersintheworld.data.remote.responses.BeerResponse
import com.captaindeer.beersintheworld.data.remote.services.BeerServices
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val client = OkHttpClient.Builder().build()

    private lateinit var beerServices: BeerServices

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.punkapi.com/v2/")
        .addConverterFactory(GsonConverterFactory.create()).client(client).build()

    suspend fun getBeers(): Response<ArrayList<BeerResponse>> {
        beerServices = retrofit.create(BeerServices::class.java)
        return beerServices.getBeers()
    }
}